package net.jbaez.et.common.impl;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import net.jbaez.et.common.i18n.IResourceService;

public class ResourceService implements IResourceService 
{
	private List<ResourceBundle> resources;
	
	public ResourceService(String... names)
	{
		this.resources = StreamSupport.stream(Arrays.spliterator(names), false)
			.map(this::findResource)
			.filter(Objects::nonNull)
			.collect(Collectors.toList());
	}
	
	@Override
	public String getMessage(String token, Object... args) 
	{
		Optional<ResourceBundle> resource = resources.stream()
			.filter(r -> r.containsKey(token))
			.findFirst();
		
		if(!resource.isPresent())
		{
			return token;
		}
		
		String mesage = resource.get().getString(token);
		return MessageFormat.format(mesage, args);
	}
	
	private ResourceBundle findResource(String name)
	{
		try {
			return ResourceBundle.getBundle(name);
		}catch (Throwable e) {
			// TODO: Logger
			return null;
		}
	}

}
