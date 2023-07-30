package com.atguigu.crowd.exception;

/**
 * 表示用戶沒有登錄就訪問受保護資源時拋出的異常
 * @author Lenovo
 *
 */
public class AccessForbiddenException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AccessForbiddenException() {
		super();
	}

	public AccessForbiddenException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AccessForbiddenException(String message, Throwable cause) {
		super(message, cause);
	}

	public AccessForbiddenException(String message) {
		super(message);
	}

	public AccessForbiddenException(Throwable cause) {
		super(cause);
	}

}
