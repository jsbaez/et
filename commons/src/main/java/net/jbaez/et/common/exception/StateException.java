package net.jbaez.et.common.exception;

public class StateException extends ETRuntimeException
{
	private static final long serialVersionUID = 2018_11_10_13_00L;

	public StateException(String token, Object... args) 
	{
		super(token, args);
	}

	public StateException(Throwable cause, String token, Object... args)
	{
		super(cause, token, args);
	}
}
