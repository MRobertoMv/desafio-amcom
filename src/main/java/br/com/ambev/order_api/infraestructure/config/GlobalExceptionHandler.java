package br.com.ambev.order_api.infraestructure.config;

import br.com.ambev.order_api.core.exceptions.DuplicateNrOrderException;
import br.com.ambev.order_api.core.exceptions.OrderBadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DuplicateNrOrderException.class)
    ProblemDetail handleDuplicateNrOrderException(DuplicateNrOrderException e) {
        return mountProblemDetail(e.getLocalizedMessage(), HttpStatus.UNPROCESSABLE_CONTENT, e.getTitle(), e.getDetail());
    }

    @ExceptionHandler(OrderBadRequestException.class)
    ProblemDetail handleOrderBadRequestException(OrderBadRequestException e) {
        return mountProblemDetail(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST, e.getTitle(), e.getDetail());
    }

    private static ProblemDetail mountProblemDetail(String messageError, HttpStatus status, String title, String detail) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(status, messageError);
        problemDetail.setTitle(title);
        problemDetail.setDetail(detail);
        problemDetail.setProperty("timestamp", LocalDateTime.now());
        return problemDetail;
    }
}
