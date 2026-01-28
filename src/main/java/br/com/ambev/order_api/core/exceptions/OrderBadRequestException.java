package br.com.ambev.order_api.core.exceptions;

public class OrderBadRequestException extends OrderGeneralException {

    private static final String TITLE_BAD_REQUEST = "Bad Request";

    public OrderBadRequestException(String detail) {
        super(TITLE_BAD_REQUEST, detail);
    }
}
