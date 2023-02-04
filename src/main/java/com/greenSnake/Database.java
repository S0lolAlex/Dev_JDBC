package com.greenSnake;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Database {
    private Connection connection;
    private static final Database SINGLE_DB =  new Database();

    private Database() {
        createDb();
    }
    private void createDb(){
        String url = "jdbc:h2:./test";
        try{
            connection = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static Database getSinglDb(){
        return SINGLE_DB;
    }
    public Connection getConnection() {
        return connection;
    }

    public String getRequestResult(String fileWay){
        StringBuilder query = new StringBuilder();
        try(FileInputStream init_db = new FileInputStream(fileWay);
            BufferedReader reader = new BufferedReader(new InputStreamReader(init_db))){
            String s;
            while((s = reader.readLine()) != null){
                query.append(s + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return query.toString();
    }




}
