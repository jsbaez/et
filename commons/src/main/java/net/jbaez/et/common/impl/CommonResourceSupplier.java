package net.jbaez.et.common.impl;

import net.jbaez.et.common.i18n.AbstractResourceSupplier;
import net.jbaez.et.common.utils.Order;

public class CommonResourceSupplier extends AbstractResourceSupplier {

	public CommonResourceSupplier()
	{
		super("net/jbaez/et/common/impl/messages", Order.LAST);
	}
}
