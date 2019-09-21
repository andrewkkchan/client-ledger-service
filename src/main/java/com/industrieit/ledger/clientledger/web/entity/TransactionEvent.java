package com.industrieit.ledger.clientledger.web.entity;

import com.industrieit.ledger.clientledger.web.model.ledger.Type;

/**
 * Entity which represents an accepted and enqueued high-level transaction, fully packed into a self-contained event
 * {@link TransactionEvent} can be consumed by consumer
 * On consumption, exactly one Transaction Result will be produced and persisted.
 * The full enqueued list of {@link TransactionEvent}, in a strict serial order, will form the basis of Event Sourcing.
 * Event sourcing allows the full state of the ledger be replayed, on any platform and infrastructure, with any processors.
 * This allows in-memory processing and reliable recovery from crash.
 */

public class TransactionEvent {
    private String id;
    private String type;
    private String request;

    /**
     * @return id which uniquely identify this transaction event.
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return payload of the request, usually a JSON string
     */
    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }


    /**
     * @return type as defined in {@link Type} which calls for correct processor
     */
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
