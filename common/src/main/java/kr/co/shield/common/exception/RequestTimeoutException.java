package kr.co.shield.common.exception;

public class RequestTimeoutException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public RequestTimeoutException(String message) {
		super(message);
	}
	
}
