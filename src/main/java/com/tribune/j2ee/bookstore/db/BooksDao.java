package com.tribune.j2ee.bookstore.db;

import com.tribune.j2ee.bookstore.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class BooksDao {


    public static int save(Book u) {
        System.out.println("saving a book");
        int status = 0;
        try {
            Connection con = ConnectionPool.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "insert into book(name,author) values(?,?)");
            ps.setString(1, u.getName());
            ps.setLong(2, u.getAuthor());
            status = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }


    // Retrieve books from H2 Database
    public static List<Book> getBooks() {
        System.out.println("Getting books");
        List<Book> books = new ArrayList<>();

        Connection conn = ConnectionPool.getInstance().getConnection();

        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();

            String query = "select * from book";
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                long prodId = rs.getLong("id");
                String name = rs.getString("name");
                long author = rs.getLong("author");

                Book p = new Book(prodId, name, author);
                books.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;

        } finally {
            //@formatter:off
            try {if (rs != null) rs.close();} catch (Exception ignored) {};
            try {if (stmt != null) stmt.close();} catch (Exception ignored) {};
            try {if (conn != null) conn.close();} catch (Exception ignored) {};
            //@formatter:on
        }
        return books;
    }
}
