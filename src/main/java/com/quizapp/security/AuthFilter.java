package com.quizapp.security;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String path = req.getRequestURI();

        // Les pages publiques
        if (path.startsWith("/login") ||
                path.startsWith("/css") ||
                path.startsWith("/js") ||
                path.startsWith("/audio")) {

            chain.doFilter(request, response);
            return;
        }

        HttpSession session = req.getSession(false);

        boolean logged = (session != null && Boolean.TRUE.equals(session.getAttribute("AUTH")));

        if (!logged) {
            resp.sendRedirect("/login");
            return;
        }

        chain.doFilter(request, response);
    }
}
