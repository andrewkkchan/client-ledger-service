package com.industrieit.ledger.clientledger.web.exception;


public class ServiceException extends RuntimeException {

    private String errorCode;

    private String errorMessage;

    public ServiceException(MessageDetail messageDetail) {
        super(messageDetail.getMessageKey());
        this.errorCode = messageDetail.getCode();
        this.errorMessage = messageDetail.getMessageKey();
    }


    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
