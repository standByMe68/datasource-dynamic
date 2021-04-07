package com.standbyme.datasourcedynamic.config;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;


@Component
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("执行过滤器前");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("执行过滤器后");
    }

    @Override
    public void destroy() {
        System.out.println();
    }
}
