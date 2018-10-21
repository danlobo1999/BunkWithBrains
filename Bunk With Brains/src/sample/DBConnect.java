package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
    static Connection connection;
    static String DB_URL="jdbc:mysql://localhost:3306/bwb";
    static Statement statement;
    public static void connect() throws SQLException {
        connection = DriverManager.getConnection(DB_URL, "root", "");
        statement = connection.createStatement();
    }
    public static Statement getStatement() {
        return statement;
    }
    public static void disconnect() throws SQLException {
        connection.close();
        statement.close();
    }
}
