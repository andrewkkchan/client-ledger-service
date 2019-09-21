package com.industrieit.ledger.clientledger.web.model.ledger;


import com.industrieit.ledger.clientledger.web.entity.TransactionEvent;

/**
 * Type of {@link TransactionEvent} allowed for the Ledger to process
 */
public enum Type {
    P2P("p2p"),
    CREATE_ACCOUNT("create-account"),
    TOP_UP("top-up"),
    BACK_UP("back-up");

    private final String text;

    Type(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
