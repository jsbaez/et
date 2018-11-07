package net.jbaez.et.common.service;

public class ServiceLocator 
{
	private static final ServiceLocator instance = new ServiceLocator();
	
	public static ServiceLocator instance()
	{
		return instance;
	}
	
	private ServiceLocator()
	{
		
	}
	
	public <T, R extends T> R findOne(Class<T> type)
	{
		return null;
	}
}
