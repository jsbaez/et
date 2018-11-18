package net.jbaez.et.common.i18n;

import java.util.Optional;
import java.util.ResourceBundle;

import net.jbaez.et.common.utils.Order;

public abstract class AbstractResourceSupplier implements IResourceSupplier {

	private String resource;
	private Order order;
	
	public AbstractResourceSupplier(String resource)
	{
		this(resource, Order.FIRTS);
	}
	
	public AbstractResourceSupplier(String resource, Order order)
	{
		this.order = order;
		this.resource = resource;
	}
	
	@Override
	public Order getOrder() 
	{
		return order;
	}

	@Override
	public Optional<ResourceBundle> getResourceBundle() 
	{
		try {
			return Optional.of(
				ResourceBundle.getBundle(resource)
			);
		}catch(Throwable t) {
			//TODO Logger
			return Optional.empty();
		}
	}

}
