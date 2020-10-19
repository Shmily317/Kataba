package com.ufo.kataba.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/19 17:38
 * description:过滤器
 */
@WebFilter("/*") //拦截所有
public class CROSFiler implements Filter {
    //过滤

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }
}
