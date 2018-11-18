package net.jbaez.et.common.i18n;

import java.util.Optional;
import java.util.ResourceBundle;

import net.jbaez.et.common.utils.Order;
import net.jbaez.et.common.utils.Sortable;

public interface IResourceSupplier extends Sortable
{
	Order getOrder();
	
	Optional<ResourceBundle> getResourceBundle();
}
