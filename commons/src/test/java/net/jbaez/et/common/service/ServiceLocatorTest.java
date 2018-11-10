package net.jbaez.et.common.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import net.jbaez.et.common.exception.ETRuntimeException;
import net.jbaez.et.common.service.test.Interface1;
import net.jbaez.et.common.service.test.Interface2;

public class ServiceLocatorTest {
	
	@Test
	public void unica_instancia_test()
	{
		ServiceLocator instance = ServiceLocator.instance();
		ServiceLocator instance2 = ServiceLocator.instance();
		Assertions.assertEquals(instance, instance2);
	}

	@Test
	public void service_not_found()
	{
		Assertions.assertThrows(ETRuntimeException.class, () -> {
			ServiceLocator instance = ServiceLocator.instance();
			instance.findOne(Interface2.class);
		});
	}
	
	@Test
	public void service_found()
	{
		ServiceLocator instance = ServiceLocator.instance();
		Interface1 interface1 = instance.findOne(Interface1.class);
		Assertions.assertNotNull(interface1);
	}
	
	@Test
	public void equals_instance_service()
	{
		ServiceLocator locator = ServiceLocator.instance();
		Interface1 instance = locator.findOne(Interface1.class);
		Interface1 instance2 = locator.findOne(Interface1.class);
		Assertions.assertEquals(instance, instance2, "No son las misma instancia");
	}
}
