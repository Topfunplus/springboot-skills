package com.example.demo.exp_eleven;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;

import java.io.IOException;


@Slf4j
//@Component
@WebFilter(value = {"/myServlet", "/anotherServlet"})
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init method of MyFilter");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("hello from MyFilter");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("destroy method of MyFilter");
        Filter.super.destroy();
    }
}
