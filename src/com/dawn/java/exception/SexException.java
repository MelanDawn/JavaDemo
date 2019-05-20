package com.dawn.java.exception;

public class SexException extends Exception {

	static final long serialVersionUID = -3042686055612345678L;

	private int errorCode;

	public SexException() {
	}

	public SexException(String msg) {
		super(msg);
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int code) {
		this.errorCode = code;
	}
}
