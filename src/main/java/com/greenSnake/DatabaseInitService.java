package com.greenSnake;

import java.sql.*;
public class DatabaseInitService {
    public static void main(String[] args) throws SQLException {
        String query = Database.getSinglDb().getRequestResult("./sql/init_db.sql");
        try(Connection conn = Database.getSinglDb().getConnection()){
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }



}
