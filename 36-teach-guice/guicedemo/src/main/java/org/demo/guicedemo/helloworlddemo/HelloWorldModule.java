package org.demo.guicedemo.helloworlddemo;

import java.io.PrintStream;
import java.util.List;

import org.demo.guicedemo.Applets;
import org.demo.guicedemo.Args;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class HelloWorldModule extends AbstractModule {

	@Override
	protected void configure() {
		Applets.register(binder()).named("hello")
			.to(StringWritingApplet.class);

		bind(MyDestination.class).to(PrintStreamWriter.class);
		bind(PrintStream.class).toInstance(System.out);
	}

	@Provides @Output String getOutputString(
			@Args List<String> args) {
		return args.get(0);
	}
}
