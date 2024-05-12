package com.tribune.j2ee.bookstore.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "TestServlet", urlPatterns = "/test-page-context")
public class PageContextTestServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        req.getSession().setAttribute("name", "Session Name");

        req.setAttribute("name", "Request Name");

        ServletContext context = getServletContext();
        context.setAttribute("name", "Application Name");

        RequestDispatcher rd = context.getRequestDispatcher("/page-context/result.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("received a post request");
        PrintWriter out = resp.getWriter();
    }
}
