package org.demo.guicedemo.server.greeting;

import org.demo.guicedemo.MyApplet;
import org.demo.guicedemo.helloworlddemo.MyDestination;
import org.demo.guicedemo.helloworlddemo.Output;
import org.demo.guicedemo.helloworlddemo.StringWritingApplet;

import com.google.inject.AbstractModule;

public class HelloWorldWebModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(MyApplet.class).to(StringWritingApplet.class);
    bind(MyDestination.class).to(WebDestination.class);

    bind(String.class).annotatedWith(Output.class)
      .toProvider(GreetingMessageProvider.class);
  }
}
