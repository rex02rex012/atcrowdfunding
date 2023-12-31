package com.atguigu.crowd.exception;

/**
 * 保存或更新Admin時如果檢測到登錄賬號重覆拋出這個異常
 * @author Lenovo
 *
 */
public class LoginAcctAlreadyInUseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public LoginAcctAlreadyInUseException() {
		super();
	}

	public LoginAcctAlreadyInUseException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public LoginAcctAlreadyInUseException(String message, Throwable cause) {
		super(message, cause);
	}

	public LoginAcctAlreadyInUseException(String message) {
		super(message);
	}

	public LoginAcctAlreadyInUseException(Throwable cause) {
		super(cause);
	}

}
