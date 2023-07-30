package com.atguigu.crowd.exception;

/**
 * 保存或更新Admin時如果檢測到登錄賬號重覆拋出這個異常
 * @author Lenovo
 *
 */
public class LoginAcctAlreadyInUseForUpdateException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public LoginAcctAlreadyInUseForUpdateException() {
		super();
	}

	public LoginAcctAlreadyInUseForUpdateException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public LoginAcctAlreadyInUseForUpdateException(String message, Throwable cause) {
		super(message, cause);
	}

	public LoginAcctAlreadyInUseForUpdateException(String message) {
		super(message);
	}

	public LoginAcctAlreadyInUseForUpdateException(Throwable cause) {
		super(cause);
	}

}
