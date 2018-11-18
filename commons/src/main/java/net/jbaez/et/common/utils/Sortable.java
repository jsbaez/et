package net.jbaez.et.common.utils;

import java.util.Comparator;

public interface Sortable 
{
	public static Comparator<Sortable> COMPARATOR = (s1, s2) -> s1.getOrder().toInt() - s2.getOrder().toInt(); 
	
	Order getOrder();
}
