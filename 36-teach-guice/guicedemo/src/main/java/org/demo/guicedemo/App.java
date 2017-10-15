package org.demo.guicedemo;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class App {
	/**
	 * bootstrap:
	 * parse command line
	 * set up environment
	 * kick off main logic
	 * @param args
	 */
	public static void main(String[] args) {
		Injector injector = Guice.createInjector(
			new MainModule(),
			new CommandLineModule(args));

		Applets.get(injector, args[0]).run();
	}
}
