package com.tribune.j2ee.bookstore.db;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class DatabaseListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();

        // Create and populate the embedded H2 database.
        DatabaseBootstrap.createPopulateH2();

        // Retrieve products from database and place into ServletContext.
//        List<Book> products = BooksDao.getBooks();
//        sc.setAttribute("books", products);
    }

}
