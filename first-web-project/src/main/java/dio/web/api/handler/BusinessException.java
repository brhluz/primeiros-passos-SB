package dio.web.api.handler;

public class BusinessException extends RuntimeException{

	public BusinessException() {
		super();
	}
	
	public BusinessException(String message, Object ... params) {
		super(String.format(message, params));
	}
	
}
