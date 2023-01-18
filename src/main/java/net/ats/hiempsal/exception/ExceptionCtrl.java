//////////////////////////////////////////////////
//
// net.ats.hiempsal.exception.ExceptionCtrl.java
// is
//
//////////////////////////////////////////////////
package net.ats.hiempsal.exception;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
*
* @author L KHERBICHE
* @since 0.0.1-RELEASE
*/
@ControllerAdvice(basePackages = {"net.ats.hiempsal"} )
public class ExceptionCtrl extends ResponseEntityExceptionHandler {

	@InitBinder
	public void dataBinding(WebDataBinder binder) {}

	@ExceptionHandler(ResourceException.class)
    public ResponseEntity<BusinessException> businessResourceError(HttpServletRequest req, ResourceException ex) {
        BusinessException be = new BusinessException();
        be.setStatus(ex.getStatus());
        be.setErrorCode(ex.getErrorCode());
        be.setErrorMessage(ex.getMessage());
        be.setRequestURL(req.getRequestURL().toString()); 
        return new ResponseEntity<BusinessException>(be, ex.getStatus());
    }
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	ValidationErrorResponse onConstraintValidationException(ConstraintViolationException e) {
		ValidationErrorResponse error = new ValidationErrorResponse();
		for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
			error.getViolations().add(new Violation(violation.getPropertyPath().toString(), violation.getMessage()));
		}
		return error;
	}
	@Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ValidationErrorResponse error = new ValidationErrorResponse();
		for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
			error.getViolations().add(new Violation(fieldError.getField(), fieldError.getDefaultMessage()));
		}
        return new ResponseEntity<>(error, status);
    }
	@ExceptionHandler(Exception.class)
    public ResponseEntity<BusinessException> unknowError(HttpServletRequest req, Exception ex) {
        BusinessException response = new BusinessException();
        response.setErrorCode("Technical Error");
        response.setErrorMessage(ex.getMessage());
        response.setRequestURL(req.getRequestURL().toString()); 
        return new ResponseEntity<BusinessException>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
