package net.jbaez.et.common.impl;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import net.jbaez.et.common.i18n.IResourceService;
import net.jbaez.et.common.i18n.IResourceSupplier;
import net.jbaez.et.common.service.ServiceLocator;
import net.jbaez.et.common.utils.ISortable;

public class CommonResourceService implements IResourceService 
{
	private List<ResourceBundle> resources;
	
	public CommonResourceService()
	{
		
	}
	
	@Override
	public String getMessage(String token, Object... args) 
	{
		if(resources == null)
		{
			List<IResourceSupplier> suppliers = ServiceLocator
				.instance().findAll(IResourceSupplier.class);
				
			resources = suppliers.stream().sorted(ISortable.COMPARATOR)
				.map(IResourceSupplier::getResourceBundle)
				.filter(Optional::isPresent).map(Optional::get)
				.collect(Collectors.toList());
		}
		
		Optional<ResourceBundle> resource = resources.stream()
			.filter(r -> r.containsKey(token)).findFirst();
		
		if(!resource.isPresent())
		{
			return token;
		}
		
		String mesage = resource.get().getString(token);
		return MessageFormat.format(mesage, args);
	}
}
