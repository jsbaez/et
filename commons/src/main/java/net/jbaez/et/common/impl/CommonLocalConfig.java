package net.jbaez.et.common.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import net.jbaez.et.common.service.ILocalConfig;

public class CommonLocalConfig implements ILocalConfig 
{
	public static final String PROPERTY_CONFIG = "et.config";
	private Properties properties;
	
	public CommonLocalConfig()
	{
		InputStream input = null;
		Properties parent = new Properties();
		
		try {
			input = readResource("net/jbaez/et/common/impl/default-config.properties");
			parent.load(input);
		}catch (IOException e) {}
		
		String path = System.getenv(PROPERTY_CONFIG);
		properties = new Properties(parent);
		try {
			input = readFile(path);
			properties.load(input);
		}catch (Exception e) {}
	}

	@Override
	public String getString(String token, String defaultValue) 
	{
		return properties.getProperty(token, defaultValue);
	}

	@Override
	public long getLong(String token, long defaultValue) 
	{
		String number = properties.getProperty(token, Long.toString(defaultValue));
		return Long.parseLong(number);
	}
	
	@Override
	public double getDouble(String token, double defaultValue)
	{
		String number = properties.getProperty(token, Double.toString(defaultValue));
		return Double.parseDouble(number);
	}

	@Override
	public boolean getBoolean(String token, boolean defaultValue)
	{
		String value = properties.getProperty(token, Boolean.toString(defaultValue));
		return Boolean.parseBoolean(value);
	}
	
	private InputStream readResource(String path) throws IOException
	{
		ClassLoader loader = getClass().getClassLoader();
		return loader.getResourceAsStream(path);
	}
	
	private InputStream readFile(String path) throws IOException
	{
		File file = new File(path);
		return new FileInputStream(file);
	}
}
