package com.dac.produtor.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/sistema-produtor/*")
public class AuthenticationFilter implements Filter {

    @Override
    public void destroy() {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse respose, FilterChain filter)
            throws IOException, ServletException {

//        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//        HttpSession session = httpServletRequest.getSession();
//        
//        if (!httpServletRequest.getRequestURI().contains("sistema-produtor/login")) {
//            if (session.getAttribute("usuario") != null) {
//                filter.doFilter(request, respose);
//            }
//            else {
//                ((HttpServletResponse) respose).sendRedirect("/sistema-produtor/login");
//            }
//        }
//        else {
//            filter.doFilter(request, respose);
//        }
        doFilter(request, respose, filter);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        
    }

}
