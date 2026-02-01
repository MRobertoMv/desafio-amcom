package br.com.ambev.order_api.core.exceptions;

public class DuplicateNrOrderException extends OrderGeneralException {

    private static final String TITLE_BAD_REQUEST = "Bad Request";

    public DuplicateNrOrderException(String detail) {
        super(TITLE_BAD_REQUEST, detail);
    }
}
