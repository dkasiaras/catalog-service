package com.kasiarakos.catalogservice.adapters.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
  private String greeting;

  public HelloController(@Value("${polar.greeting}") String greeting) {
    this.greeting = greeting;
  }

  @GetMapping("/hello")
  public String hello() {
    return greeting;
  }
}
