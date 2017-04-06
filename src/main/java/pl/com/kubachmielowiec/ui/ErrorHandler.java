package pl.com.kubachmielowiec.ui;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.com.kubachmielowiec.application.AlreadyAppliedException;
import pl.com.kubachmielowiec.application.InvalidLoginDataException;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(AlreadyAppliedException.class)
    public ResponseEntity<String> handleValidationFailedException(AlreadyAppliedException ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, "text/html");
        return new ResponseEntity<String>(
                String.format("Error: %s", ex.getMessage()),
                headers,
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(InvalidLoginDataException.class)
    public ResponseEntity<String> handleInvalidLoginDataExceotion(InvalidLoginDataException ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, "text/html");
        return new ResponseEntity<String>(
                String.format("Error: %s", ex.getMessage()),
                headers,
                HttpStatus.UNAUTHORIZED
        );
    }

}
