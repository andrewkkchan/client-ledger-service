package com.industrieit.ledger.clientledger.web.model.request;


import com.fasterxml.jackson.databind.JsonNode;
import com.industrieit.ledger.clientledger.web.entity.TransactionEvent;
import com.industrieit.ledger.clientledger.web.model.ledger.Type;

/**
 * Envelop object which maps to request body for creating {@link TransactionEvent}
 */
public class RequestEnvelop {

    private String id;

    /**
     * @return a type which must be within the range of {@link Type} to be accepted
     */
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type;

    private JsonNode request;

    /**
     * @return an important field for idempotency, must be generated from the client using {@link java.util.UUID} when in production
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return any JSON object which is the payload for creating {@link TransactionEvent}
     */
    public JsonNode getRequest() {
        return request;
    }

    public void setRequest(JsonNode request) {
        this.request = request;
    }
}
