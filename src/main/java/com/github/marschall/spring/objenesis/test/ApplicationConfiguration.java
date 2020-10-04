package com.github.marschall.spring.objenesis.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ApplicationConfiguration {

  @Autowired
  private ApplicationContext applicationContext;

  @Bean
  @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
  public ApplicationBean applicationBean() {
    return new ApplicationBean(this.applicationContext);
  }

}
