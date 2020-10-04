package com.github.marschall.spring.objenesis.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringObjenesisTest extends HttpServlet {

  private ConfigurableApplicationContext applicationContext;

  @Override
  public void init() throws ServletException {
    this.applicationContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
  }

  @Override
  public void destroy() {
    this.applicationContext.close();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setCharacterEncoding("US-ASCII");
    PrintWriter writer = response.getWriter();
    writer.write("ok:" + this.applicationContext.getBean(ApplicationBean.class));
  }

}
