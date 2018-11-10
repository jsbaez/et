package net.jbaez.et.common.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import net.jbaez.et.common.service.ServiceLocator;

public class IResourceServiceTest 
{
	@Test
	public void test_resources_service()
	{
		IResourceService resources = ServiceLocator.instance()
			.findOne(IResourceService.class);
		
		String actual = resources.getMessage("et.app.commercial.name");
		Assertions.assertEquals("ET Trading", actual);
	}
}
