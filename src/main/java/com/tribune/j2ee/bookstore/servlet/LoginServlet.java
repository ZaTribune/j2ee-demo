package com.tribune.j2ee.bookstore.servlet;


import com.tribune.j2ee.bookstore.db.BooksDao;
import com.tribune.j2ee.bookstore.model.WebUser;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");


        String name = StringUtils.defaultString(request.getParameter("username"));
        String password = StringUtils.defaultString(request.getParameter("password"));

        WebUser webUser = new WebUser();
        webUser.setName(name);
        webUser.setPassword(password);
        request.setAttribute("bean", webUser);

        boolean status = validate(webUser);

        RequestDispatcher rd;
        if (status) {
            request.getSession().setAttribute("username", webUser.getName());
            response.sendRedirect("index.jsp");
        } else {
            System.out.println("Not Authenticated");
            rd = request.getRequestDispatcher("error/login-failure.jsp");
            rd.forward(request, response);
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("components/login.jsp");
        rd.forward(req, resp);
    }

    public boolean validate(WebUser webUser){
        if (webUser.getName().equals("admin") && webUser.getPassword().equals("1234")){
            return true;
        }
        return false;
    }
}
