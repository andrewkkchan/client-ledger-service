package com.industrieit.ledger.clientledger.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.industrieit.ledger.clientledger.web.entity.TransactionEvent;
import com.industrieit.ledger.clientledger.web.exception.LedgerServiceErrorMessage;
import com.industrieit.ledger.clientledger.web.exception.ServiceException;
import com.industrieit.ledger.clientledger.web.model.ledger.Type;
import com.industrieit.ledger.clientledger.web.model.request.RequestEnvelop;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * REST Controller which is exclusively allowed to POST on the Ledger through creating and enqueuing {@link TransactionEvent}
 */
@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, TransactionEvent> kafkaTemplate;
    public static final String TOPIC = "Transaction_Event";



    public TransactionController(
            ObjectMapper objectMapper,
            KafkaTemplate<String, TransactionEvent> kafkaTemplate) {
        this.objectMapper = objectMapper;
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * Create and Enqueue one {@link TransactionEvent} onto the Blocking Queue for consumer to consume.
     * Raise {@link ServiceException} if unable to read the request JSON body, or the request type is not supported by {@link Type}
     *
     * @param requestEnvelop request for a transaction which mutates the Ledger's state
     * @return one {@link TransactionEvent} either created and enqueued, or already in the queue
     */
    @PostMapping(value = "/event",
            produces = {"application/json"},
            consumes = {"application/json"})
    @ResponseBody
    public TransactionEvent queueTransaction(@RequestBody RequestEnvelop requestEnvelop) {
        TransactionEvent transactionEvent = new TransactionEvent();
        try {
            transactionEvent.setRequest(objectMapper.writeValueAsString(requestEnvelop.getRequest()));
        } catch (JsonProcessingException e) {
            throw new ServiceException(LedgerServiceErrorMessage.REQUEST_UNREADABLE);
        }
        transactionEvent.setId(requestEnvelop.getId() == null ? UUID.randomUUID().toString() : requestEnvelop.getId());
        for (Type type : Type.values()) {
            if (requestEnvelop.getType().equals(type.toString())) {
                transactionEvent.setType(requestEnvelop.getType());
                kafkaTemplate.send(TOPIC, transactionEvent);
                return transactionEvent;
            }
        }
        throw new ServiceException(LedgerServiceErrorMessage.TYPE_NOT_SUPPORTED);
    }


}
