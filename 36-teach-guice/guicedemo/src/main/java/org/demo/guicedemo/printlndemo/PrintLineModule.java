package org.demo.guicedemo.printlndemo;

import org.demo.guicedemo.Applets;

import com.google.inject.AbstractModule;

public class PrintLineModule extends AbstractModule {

	@Override
	protected void configure() {
		Applets.register(binder()).named("println")
			.to(PrintLineApplet.class);
	}
}
