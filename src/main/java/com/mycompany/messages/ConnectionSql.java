package com.mycompany.messages;

import java.sql.*;

public class ConnectionSql {
    private static final String URL = "jdbc:mysql://localhost/messages_db?serverTimeZone=UTC";
    private static final String USER = "root";
    private static final String PASS = "Passwordsql123";
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL,USER,PASS);
    }
    
    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }
    
    public static void close(PreparedStatement ps) throws SQLException {
        ps.close();
    }
    
    public static void close(Connection cn) throws SQLException {
        cn.close();
    }
}
