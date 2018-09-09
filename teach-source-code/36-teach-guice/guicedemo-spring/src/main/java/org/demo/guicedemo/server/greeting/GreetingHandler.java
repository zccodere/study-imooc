package org.demo.guicedemo.server.greeting;

import javax.inject.Inject;

import org.demo.guicedemo.MyApplet;

import com.google.inject.servlet.RequestScoped;

@RequestScoped
public class GreetingHandler {

  private final RequestParams params;
  private final WebDestination destination;
  private final MyApplet applet;

  @Inject
  public GreetingHandler(
      RequestParams params,
      WebDestination destination,
      MyApplet applet) {
    this.params = params;
    this.destination = destination;
    this.applet = applet;
  }

  public String getByName(String name) {
    params.setGreetingName(name);
    applet.run();
    return destination.getResult();
  }
}
