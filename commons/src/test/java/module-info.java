open module et.commons
{
	exports net.jbaez.et.common.i18n;
	exports net.jbaez.et.common.service;
	exports net.jbaez.et.common.exception;
	
	exports net.jbaez.et.common.service.test;
	exports net.jbaez.et.common.service.impl   ;
	
	requires org.junit.jupiter.api;
	
	uses net.jbaez.et.common.service.test.Interface1;
	provides net.jbaez.et.common.service.test.Interface1 with net.jbaez.et.common.service.impl.Interface1Impl;
}

