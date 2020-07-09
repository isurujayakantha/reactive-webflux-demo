package com.jayk.demos.reactive.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class ReactiveDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(ReactiveDemoApplication.class, args);
  }

}
