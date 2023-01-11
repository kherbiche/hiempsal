//////////////////////////////////////////////////
//
// net.ats.hiempsal.exception.ExceptionCtrl.java
// is
//
//////////////////////////////////////////////////
package net.ats.hiempsal.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
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
	@ExceptionHandler(Exception.class)
    public ResponseEntity<BusinessException> unknowError(HttpServletRequest req, Exception ex) {
        BusinessException response = new BusinessException();
        response.setErrorCode("Technical Error");
        response.setErrorMessage(ex.getMessage());
        response.setRequestURL(req.getRequestURL().toString()); 
        return new ResponseEntity<BusinessException>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
