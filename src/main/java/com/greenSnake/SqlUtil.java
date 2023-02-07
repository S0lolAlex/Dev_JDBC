package com.greenSnake;

import java.sql.*;
import java.util.function.Consumer;

public class SqlUtil {
    public void executeUpdateSql(String sql) {
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement();) {
            statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void executeQuerySql(String sql, Consumer<ResultSet> consum) {
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rest = statement.executeQuery(sql);)
        {
            consum.accept(rest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
