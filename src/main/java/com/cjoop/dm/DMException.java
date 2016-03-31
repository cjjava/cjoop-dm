package com.cjoop.dm;

/**
 * 大漠插件异常信息
 * @author 陈均
 *
 */
public class DMException extends RuntimeException{

	private static final long serialVersionUID = -8190016153946289383L;

	public DMException() {
		super();
	}

	public DMException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DMException(String message, Throwable cause) {
		super(message, cause);
	}

	public DMException(String message) {
		super(message);
	}

	public DMException(Throwable cause) {
		super(cause);
	}

}
