package net.jbaez.et.common.exception;

import net.jbaez.et.common.i18n.IResourceService;
import net.jbaez.et.common.service.ServiceLocator;

public class ETRuntimeException extends RuntimeException 
{
	private static final long serialVersionUID = 2018_11_07_20_48L;
	
	private String token;
	private Object[] args;
	
	public ETRuntimeException(String token, Object... args)
	{
		super(token);
		this.token = token;
		this.args = args;
	}
	
	public ETRuntimeException(Throwable cause, String token, Object... args)
	{
		super(token, cause);
		this.token = token;
		this.args = args;
	}

	@Override
	public String getLocalizedMessage() 
	{
		IResourceService resource = ServiceLocator.instance().findOne(IResourceService.class);
		return resource.getMessage(token, args);
	}
}
