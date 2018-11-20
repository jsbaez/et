package net.jbaez.et.common.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ILocalConfigTest 
{

	private ILocalConfig localConfig = ServiceLocator
		.instance().findOne(ILocalConfig.class);
	
	@Test
	public void test_config_string()
	{
		String texto = localConfig.getString("et.config.string", null);
		Assertions.assertEquals("Texto", texto);
	}
	
	@Test
	public void test_config_boolean()
	{
		boolean value = localConfig.getBoolean("et.config.boolean", false);
		Assertions.assertEquals(true, value);
	}
	
	@Test
	public void test_config_long()
	{
		long value = localConfig.getLong("et.config.long", 0L);
		Assertions.assertEquals(123, value);
	}
	
	@Test
	public void test_config_double()
	{
		double value = localConfig.getDouble("et.config.double", 0D);
		Assertions.assertEquals(123.45, value);
	}
}
