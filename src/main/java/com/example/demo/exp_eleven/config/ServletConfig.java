package com.example.demo.exp_eleven.config;


import com.example.demo.exp_eleven.MyFilter;
import com.example.demo.exp_eleven.MyListener;
import com.example.demo.exp_eleven.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;

import java.util.List;

//@Configuration
public class ServletConfig {

    @Bean
    public ServletRegistrationBean<MyServlet> getServlet() {
        System.out.println("ServletConfig.getServlet");
        ServletRegistrationBean<MyServlet> registrationBean = new ServletRegistrationBean<>(new MyServlet());
        registrationBean.addUrlMappings("/myServlet");
        return registrationBean;
    }

    @Bean
    public ServletRegistrationBean getAnotherServlet(MyServlet myServlet) {
        System.out.println("ServletConfig.getAnotherServlet");
        ServletRegistrationBean<MyServlet> myServletServletRegistrationBean
                = new ServletRegistrationBean<>(myServlet, "/anotherServlet");

        return myServletServletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean getFilter(MyFilter myFilter) {
        System.out.println("ServletConfig.getFilter");
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myFilter);
        filterRegistrationBean.setUrlPatterns(List.of("/myServlet", "/anotherServlet"));
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean getListener(MyListener myListener) {
        System.out.println("ServletConfig.getListener");
        ServletListenerRegistrationBean<MyListener> servletRegistrationBean = new ServletListenerRegistrationBean<>(myListener);
        return servletRegistrationBean;
    }
}
