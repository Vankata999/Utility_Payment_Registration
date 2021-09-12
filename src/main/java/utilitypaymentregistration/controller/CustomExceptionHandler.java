package utilitypaymentregistration.controller;

import java.io.IOException;
import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import utilitypaymentregistration.Repository.SubscriptionRepository;
import utilitypaymentregistration.data.EResponse;
import utilitypaymentregistration.data.Subscription;
import utilitypaymentregistration.data.EResponse.ResponseStatus;
import utilitypaymentregistration.errormessage.ErrorMessage;


@SuppressWarnings({ "unchecked", "rawtypes" })
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	@Autowired
	SubscriptionRepository rep;
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		EResponse error = new EResponse();
		error.setStatus(ResponseStatus.G_ERROR);
		error.setErrorCode(ResponseStatus.G_ERROR.getCode());
		error.setErrorDes(ResponseStatus.G_ERROR.name());
		
		return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

	@ExceptionHandler(ErrorMessage.class)
	public final ResponseEntity<Object> handleUserNotFoundException(ErrorMessage ex, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		EResponse error = new EResponse();
		error.setStatus(ex.getStatus());
		error.setErrorCode(ex.getStatus().getCode());
		error.setErrorDes(ex.getStatus().name());
		return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	}

//	public final void handleCheckBillError(Exception ex, WebRequest request)
//	{
//		List<String> details = new ArrayList<>();
//		details.add(ex.getLocalizedMessage());
//		EResponse error = new EResponse();
//	
//	}
//	
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<>();
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			details.add(error.getDefaultMessage());
		}
		EResponse error = new EResponse();
		error.setStatus(ResponseStatus.INVALID_FORMAT);
		error.setErrorCode(ResponseStatus.INVALID_FORMAT.getCode());
		error.setErrorDes(ResponseStatus.INVALID_FORMAT.name());
		return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	}
}