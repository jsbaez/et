package net.jbaez.et.common.service;

import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import net.jbaez.et.common.exception.ElementNotFound;
import net.jbaez.et.common.exception.StateException;

public class ServiceLocator 
{
	private static final ServiceLocator instance = new ServiceLocator();
	
	public static ServiceLocator instance()
	{
		return instance;
	}
	
	private Map<Class<?>, ServiceLoader<?>> loaderCache = new ConcurrentHashMap<>();
	
	private ServiceLocator()
	{
		
	}
	
	public <T> T findOne(Class<T> type) throws ElementNotFound, StateException
	{
		List<T> service = findServices(type);
		if(service.size() > 1)
		{
			throw new StateException("Mas de un servicio", type.getCanonicalName());
		}
		
		return service.get(0);
	}
	
	public <T> List<T> findAll(Class<T> type) throws ElementNotFound
	{
		return findServices(type);
	}
	
	@SuppressWarnings("unchecked")
	private <T> List<T> findServices(Class<T> type)
	{
		ServiceLoader<T> services = null;			
		if(!loaderCache.containsKey(type))
		{
			services = ServiceLoader.load(type);
			loaderCache.put(type, services);
		}else {			
			services = (ServiceLoader<T>) loaderCache.get(type);
		}
		
		Stream<T> stream = StreamSupport.stream(services.spliterator(), false);
		List<T> result = stream.collect(Collectors.toList());
		
		if(result.isEmpty())
		{
			throw new ElementNotFound("No existe el servicio {0}", type.getCanonicalName()); 
		}
		
		return result;
	}
}
