package com.test.spring;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        System.out.println("进入 FirstFilter ");
        httpServletResponse.setHeader("Pragma", "No-cache");
        httpServletResponse.setHeader("Cache-Control", "no-cache");
//        Status Code: 401
//        httpServletResponse.setStatus(401);
        return;
//        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
