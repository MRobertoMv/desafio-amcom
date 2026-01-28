package br.com.ambev.order_api.core.exceptions;

public abstract class OrderGeneralException extends RuntimeException {
    public OrderGeneralException(String title, String detail) {
        super(detail);
        this.title = title;
        this.detail = detail;
    }

    protected String title;
    protected String detail;

    public String getTitle() {
        return title;
    }

    public String getDetail() {
        return detail;
    }
    
}
