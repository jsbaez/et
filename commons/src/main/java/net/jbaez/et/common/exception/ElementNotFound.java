package net.jbaez.et.common.exception;

public class ElementNotFound extends ETRuntimeException 
{
	private static final long serialVersionUID = 2018_11_10_12_53L;

	public ElementNotFound(String token, Object... args) 
	{
		super(token, args);
	}

	public ElementNotFound(Throwable cause, String token, Object... args)
	{
		super(cause, token, args);
	}
}
