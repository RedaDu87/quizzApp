package com.quizapp.security;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String path = req.getRequestURI();

        boolean isLogged = req.getSession().getAttribute("AUTH") != null;

        // URLs publiques
        if (path.startsWith("/login") ||
                path.startsWith("/css") ||
                path.startsWith("/js") ||
                path.startsWith("/audio") ||
                path.equals("/")) {

            chain.doFilter(request, response);
            return;
        }

        // Protection des pages quiz et admin
        if ((path.startsWith("/quiz") || path.startsWith("/admin")) && !isLogged) {
            res.sendRedirect("/login");
            return;
        }

        chain.doFilter(request, response);
    }
}
