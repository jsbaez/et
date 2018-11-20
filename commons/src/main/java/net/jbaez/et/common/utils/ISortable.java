package net.jbaez.et.common.utils;

import java.util.Comparator;

public interface ISortable 
{
	public static Comparator<ISortable> COMPARATOR = (s1, s2) 
			-> s1.getOrder().toInt() - s2.getOrder().toInt(); 
	
	Order getOrder();
}
