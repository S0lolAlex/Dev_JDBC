package com.greenSnake;

import java.sql.*;

public class DatabasePopulateService {
    public static void main(String[] args) throws SQLException {
        String query = Database.getSinglDb().getRequestResult("./sql/populate_db.sql");
        Connection conn = Database.getSinglDb().getConnection();
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);
    }
}
