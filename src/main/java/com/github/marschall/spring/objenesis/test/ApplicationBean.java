package com.github.marschall.spring.objenesis.test;

import org.springframework.context.ApplicationContext;

public class ApplicationBean {

  private final ApplicationContext applicationContext;

  public ApplicationBean(ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
  }

}
