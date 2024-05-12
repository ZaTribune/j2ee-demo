package com.tribune.j2ee.bookstore.db;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseBootstrap {

    // Create and populate Product table in H2 Database
    public static void createPopulateH2() {
        ConnectionPool pool = ConnectionPool.getInstance();

        try (Connection conn = pool.getConnection()) {
            final String createAuthorTable = "DROP TABLE IF EXISTS Author;"
                    + "CREATE TABLE Author("
                    + "id bigint NOT NULL AUTO_INCREMENT,"
                    + "name VARCHAR(100) NOT NULL DEFAULT '',"
                    + "PRIMARY KEY (id));";
            final String createBookTable = "DROP TABLE IF EXISTS Book;"
                    + "CREATE TABLE Book("
                    + "id bigint NOT NULL AUTO_INCREMENT,"
                    + "name VARCHAR(100) NOT NULL DEFAULT '',"
                    + "author bigint NOT NULL references Author(id),"
                    + "PRIMARY KEY (id));";
            final String populateAuthorTable = "INSERT INTO Author VALUES"
                    + "('1','John Doe'),"
                    + "('2','Donald Trump'),"
                    + "('3','Vladimir Putin'),"
                    + "('4','Muhammad Ali');";
            final String populateBookTable = "INSERT INTO Book VALUES"
                    + "('1', 'To Kill a Mockingbird', '1'),"
                    + "('2', '1984', '1'),"
                    + "('3', 'The Great Gatsby', '1'),"
                    + "('4', 'Pride and Prejudice', '2'),"
                    + "('5', 'The Catcher in the Rye', '2'),"
                    + "('6', 'Animal Farm', '3'),"
                    + "('7', 'Brave New World', '4'),"
                    + "('8', 'Lord of the Flies', '4'),"
                    + "('9', 'The Grapes of Wrath', '4'),"
                    + "('10', 'To the Lighthouse', '4'),"
                    + "('11', 'The Hobbit', '4'),"
                    + "('12', 'The Lord of the Rings', '4'),"
                    + "('13', 'The Old Man and the Sea', '4'),"
                    + "('14', 'Moby-Dick', '4'),"
                    + "('15', 'Alice Adventures in Wonderland', '4');";
            conn.createStatement().executeUpdate(createAuthorTable);
            conn.createStatement().executeUpdate(populateAuthorTable);
            conn.createStatement().executeUpdate(createBookTable);
            conn.createStatement().executeUpdate(populateBookTable);

        } catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }
    }
}
