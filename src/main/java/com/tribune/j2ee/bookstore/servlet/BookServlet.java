package com.tribune.j2ee.bookstore.servlet;


import com.tribune.j2ee.bookstore.db.BooksDao;
import com.tribune.j2ee.bookstore.model.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookServlet", urlPatterns = "/books")
public class BookServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Getting books from servlet");
        response.setContentType("text/html");

        List<Book> list = BooksDao.getBooks();
        System.out.println("list size:" + list.size());
        request.setAttribute("bookList", BooksDao.getBooks());

        RequestDispatcher rd = request.getRequestDispatcher("books/view-books.jsp");
        rd.forward(request, response);
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
}
