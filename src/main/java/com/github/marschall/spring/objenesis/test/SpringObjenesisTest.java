package com.github.marschall.spring.objenesis.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.objenesis.SpringObjenesis;

public class SpringObjenesisTest extends HttpServlet {

  private volatile ConfigurableApplicationContext applicationContext;
  private volatile SpringObjenesis springObjenesis;

  @Override
  public void init() throws ServletException {
    this.applicationContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
    this.springObjenesis = new SpringObjenesis();
  }

  @Override
  public void destroy() {
    this.applicationContext.close();
    this.applicationContext = null;
    this.springObjenesis = null;
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setCharacterEncoding("US-ASCII");
    PrintWriter writer = response.getWriter();
    writer.write("ok:" + this.applicationContext.getBean(ApplicationBean.class));
    writer.write("\r\n");
    writer.write("ok:" + this.springObjenesis.newInstance(ApplicationBean.class));
  }

}
