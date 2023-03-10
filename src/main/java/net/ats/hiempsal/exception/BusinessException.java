package net.ats.hiempsal.exception;

import org.springframework.http.HttpStatus;

public class BusinessException {
	private String errorCode;
	private String errorMessage;
	private String requestURL;
	private HttpStatus status;

	public BusinessException() {
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void setRequestURL(String url) {
		this.requestURL = url;

	}

	public String getRequestURL() {
		return requestURL;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
}
