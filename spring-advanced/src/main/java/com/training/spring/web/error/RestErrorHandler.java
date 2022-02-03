package com.training.spring.web.error;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.training.spring.security.RestSecurityException;

@RestControllerAdvice
public class RestErrorHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleError(final IllegalArgumentException exp) {
        ErrorObj errorObjLoc = new ErrorObj();
        errorObjLoc.setCause(10001);
        errorObjLoc.setMessage("illegal argument : " + exp.getMessage());
        return errorObjLoc;
    }

    @ExceptionHandler(RestSecurityException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorObj handleError(final RestSecurityException exp) {
        ErrorObj errorObjLoc = new ErrorObj();
        errorObjLoc.setCause(23001);
        errorObjLoc.setMessage(exp.getMessage());
        return errorObjLoc;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorObj> handleError(final MethodArgumentNotValidException exp) {
        ErrorObj errorObjLoc = new ErrorObj();
        errorObjLoc.setCause(10002);
        errorObjLoc.setMessage("Validasyon patladı");
        List<ObjectError> allErrorsLoc = exp.getAllErrors();
        for (ObjectError objectErrorLoc : allErrorsLoc) {
            errorObjLoc.addSubError(new ErrorObj().setMessage(objectErrorLoc.toString())
                                                  .setCause(10023));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                             .header("error",
                                     "valid error")
                             .body(errorObjLoc);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorObj> handleError(final ConstraintViolationException exp) {
        ErrorObj errorObjLoc = new ErrorObj();
        errorObjLoc.setCause(10002);
        errorObjLoc.setMessage("Validasyon patladı");
        Set<ConstraintViolation<?>> allErrorsLoc = exp.getConstraintViolations();
        for (ConstraintViolation<?> objectErrorLoc : allErrorsLoc) {
            errorObjLoc.addSubError(new ErrorObj().setMessage(objectErrorLoc.toString())
                                                  .setCause(10023));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                             .header("error",
                                     "valid error")
                             .body(errorObjLoc);
    }

}
