package com.tribune.j2ee.bookstore.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter
public class AuthenticationFilter implements Filter {


    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        if (req instanceof HttpServletRequest) {

            HttpServletRequest request = (HttpServletRequest) req;
            System.out.println("Requesting - " + request.getServletPath());

            HttpServletResponse response = (HttpServletResponse) resp;
            HttpSession session = request.getSession();

            // Check if the user is authenticated
            boolean isLoggedIn = session != null && session.getAttribute("username") != null;

            // Allow access to login page and authentication servlet
            String loginURI = request.getContextPath() + "/login";

            boolean isLoginRequest = request.getRequestURI().equals(loginURI);
            boolean isLoginPage = request.getRequestURI().endsWith("login.jsp");
            boolean isLoginFailure = request.getRequestURI().endsWith("login-failure.jsp");

            System.out.println("isLoggedIn: " + isLoggedIn +
                    ", isLoginRequest: " + isLoginRequest +
                    ", isLoginPage: " + isLoginPage +
                    ", isLoginFailure: " + isLoginFailure);

            if (isLoggedIn || isLoginRequest || isLoginPage || isLoginFailure) {
                System.out.println("Forwarding to " + request.getServletPath());
                // User is authenticated or requesting login page, proceed with the request
                chain.doFilter(request, response);
            } else {
                System.out.println("Not authenticated");
                // User is not authenticated and trying to access other pages, redirect to login page
                response.sendRedirect("/login");
            }
        }


    }

    void printCookies(HttpServletRequest request) {
        //scan for cookies
        Cookie[] ck = request.getCookies();
        for (Cookie cookie : ck) {
            System.out.println("Cookie name:" + cookie.getName() + ", value = " + cookie.getValue());//printing name and value of cookie
        }
    }

}
