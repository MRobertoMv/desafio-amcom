package br.com.ambev.order_api.core.exceptions;

public class OrderCalculatedNotFoundException extends OrderGeneralException {

    private static final String TITLE_BAD_REQUEST = "Not Found";

    public OrderCalculatedNotFoundException(String detail) {
        super(TITLE_BAD_REQUEST, detail);
    }
}
