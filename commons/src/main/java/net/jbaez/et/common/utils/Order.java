package net.jbaez.et.common.utils;

public final class Order 
{
	private static final int INT_FIRTS = 0;
	private static final int INT_LAST = 1000000;
	
	public static final Order LAST = new Order(INT_LAST);
	public static final Order FIRTS = new Order(INT_FIRTS);
	
	private int order;
	
	Order(int order)
	{
		this.order = order;
	}
	
	int toInt()
	{
		return order;
	}
}
