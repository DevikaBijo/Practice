package com.example.SamplePratice.Exception;

import com.example.SamplePratice.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = IDNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleIDNotFoundExceptionn (IDNotFoundException ex,
                                                                       WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
    @ExceptionHandler(value = NameNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleNameNotFoundException (NameNotFoundException ex,
                                                                    WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

}
