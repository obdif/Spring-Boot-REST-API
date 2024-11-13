package com.api.downupload.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.api.downupload.model.ResponseError;

@ControllerAdvice
public class FileExceptionAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<Object> handleFileNotFoundException(FileNotFoundException exc) {
        List<String> details = new ArrayList<>();
        details.add(exc.getMessage());
        ResponseError err = new ResponseError(LocalDateTime.now(), "File Not Found", details);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<Object> handleMaxSizeException(MaxUploadSizeExceededException exc) {
        List<String> details = new ArrayList<>();
        details.add("The uploaded file exceeds the maximum allowed size.");
        ResponseError err = new ResponseError(LocalDateTime.now(), "File Size Exceeded", details);
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(err);
    }

    // Catch any other exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception exc) {
        List<String> details = new ArrayList<>();
        details.add(exc.getMessage());
        ResponseError err = new ResponseError(LocalDateTime.now(), "Internal Server Error", details);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
    }
}
