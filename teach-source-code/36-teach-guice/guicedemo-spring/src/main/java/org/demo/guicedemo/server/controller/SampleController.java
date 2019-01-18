package org.demo.guicedemo.server.controller;

import org.demo.guicedemo.server.SpringScanBase;
import org.demo.guicedemo.server.greeting.GreetingHandler;
import org.demo.guicedemo.server.greeting.HelloWorldWebModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.google.inject.Guice;
import com.google.inject.Injector;

@RestController
@SpringBootApplication(
    scanBasePackageClasses = SpringScanBase.class)
@ServletComponentScan
public class SampleController {

  @Bean Injector injector(ApplicationContext context) {
    return Guice.createInjector(
        new HelloWorldWebModule(),
        new SpringAwareServletModule(context));
  }

  @Bean @RequestScope GreetingHandler greetingHandler(
      Injector injector) {
    return injector.getInstance(GreetingHandler.class);
  }

  @Autowired GreetingHandler greetingHandler;

  @GetMapping("/greeting")
  String greeting(@RequestParam("name") String name) {
    return greetingHandler.getByName(name);
  }

  public static void main(String[] args) throws Exception {
    SpringApplication.run(SampleController.class, args);
  }
}
