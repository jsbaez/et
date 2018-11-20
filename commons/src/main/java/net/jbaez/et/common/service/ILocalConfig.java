package net.jbaez.et.common.service;

public interface ILocalConfig 
{
	long getLong(String token, long defaultValue);
	double getDouble(String token, double defaultValue);
	String getString(String token, String defaultValue);
	boolean getBoolean(String token, boolean defaultValue);
}
