package org.demo.guicedemo.server.greeting;

import javax.inject.Inject;

import org.demo.guicedemo.helloworlddemo.MyDestination;

import com.google.inject.servlet.RequestScoped;

@RequestScoped
public class WebDestination implements MyDestination {
  private final StringBuilder sb;

  @Inject
  public WebDestination() {
    System.out.println("WebDestination constructed.");
    this.sb = new StringBuilder();
  }

  @Override
  public void write(String string) {
    sb.append(string);
  }

  public String getResult() {
    return sb.toString();
  }
}
