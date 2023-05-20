package com.pack.exceptions;

public class HeaderNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public HeaderNotFoundException(String msg)
	{
		super(msg);
	}
}
