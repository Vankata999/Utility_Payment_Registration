package utilitypaymentregistration.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;
import utilitypaymentregistration.data.EResponse;
import utilitypaymentregistration.data.EResponse.ResponseStatus;
import utilitypaymentregistration.data.ErrorMessage;
@Slf4j
@SuppressWarnings({ "unchecked", "rawtypes" })
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(value = { Exception.class })
    public ResponseEntity<Object> handleGeneralExceptions(Exception ex, WebRequest request) {
        log.error("Exception: " + ResponseStatus.G_ERROR);
       
        EResponse res = new EResponse();
       
        res.setStatus(ResponseStatus.G_ERROR);
        res.setErrorCode(ResponseStatus.G_ERROR.getCode());
        res.setErrorDes(ResponseStatus.G_ERROR.name());
       
        return new ResponseEntity(res, HttpStatus.NOT_FOUND);
}
   
    @ExceptionHandler(value = { ErrorMessage.class })
    public ResponseEntity<Object> handleEExceptions(ErrorMessage ex, WebRequest request) {
            log.error("Exception: " + ex.getStatus());
           
            EResponse res = new EResponse();
           
            res.setStatus(ex.getStatus());
            res.setErrorCode(ex.getStatus().getCode());
            res.setErrorDes(ex.getStatus().name());
           
            return new ResponseEntity(res, HttpStatus.NOT_FOUND);
    }
}