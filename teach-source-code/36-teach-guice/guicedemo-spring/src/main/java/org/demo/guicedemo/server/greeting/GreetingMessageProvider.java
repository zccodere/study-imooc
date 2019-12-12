package org.demo.guicedemo.server.greeting;

import javax.inject.Inject;

import org.demo.guicedemo.server.persistence.SampleDao;

import com.google.inject.Provider;

public class GreetingMessageProvider
    implements Provider<String> {
  private final RequestParams params;
  private final SampleDao dao;

  @Inject
  public GreetingMessageProvider(
      RequestParams params, SampleDao dao) {
    this.params = params;
    this.dao = dao;
  }

  @Override
  public String get() {
    String name = params.getGreetingName();
    dao.getPersonData(name);
    return "Hello " + name;
  }
}
