//////////////////////////////////////////////////////
//
// net.ats.hiempsal.exception.ResourceException.java
// is
//
/////////////////////////////////////////////////////
package net.ats.hiempsal.exception;

import org.springframework.http.HttpStatus;

/**
*
* @author L KHERBICHE
* @since 0.0.1-RELEASE
*/
public class ResourceException extends RuntimeException {
	private Long resourceId;
    private String errorCode;
    private HttpStatus status;

    public ResourceException(String message) {
        super(message);
    }
    
    public ResourceException(Long resourceId, String message) {
        super(message);
        this.resourceId = resourceId;
    }
    public ResourceException(Long resourceId, String errorCode, String message) {
        super(message);
        this.resourceId = resourceId;
        this.errorCode = errorCode;
    }
    
    public ResourceException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
    
    public ResourceException(String errorCode, String message, HttpStatus status) {
        super(message);
        this.errorCode = errorCode;
        this.status = status;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }    
    
    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
