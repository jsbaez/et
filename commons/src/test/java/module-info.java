open module et.commons
{
	exports net.jbaez.et.common.i18n;
	exports net.jbaez.et.common.utils;
	exports net.jbaez.et.common.service;
	exports net.jbaez.et.common.exception;
	
	provides net.jbaez.et.common.service.ILocalConfig with net.jbaez.et.common.impl.CommonLocalConfig;
	provides net.jbaez.et.common.i18n.IResourceService with net.jbaez.et.common.impl.CommonResourceService;
	provides net.jbaez.et.common.i18n.IResourceSupplier with net.jbaez.et.common.impl.CommonResourceSupplier;
	
	requires org.junit.jupiter.api;
}

