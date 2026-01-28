package br.com.ambev.order_api.infraestructure.config;

import br.com.ambev.order_api.core.exceptions.OrderBadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(OrderBadRequestException.class)
    ProblemDetail handleOrderBadRequestException(OrderBadRequestException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        problemDetail.setTitle(e.getTitle());
        problemDetail.setDetail(e.getDetail());
        return problemDetail;

    }
}
