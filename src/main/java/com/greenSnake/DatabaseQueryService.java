package com.greenSnake;
import sqlRequestUsers.*;
import java.sql.*;
import java.util.*;
public class DatabaseQueryService {
    private String getSqlRequest(String path) {
        return Database.getRequestResult(path);
    }
    public List<MaxProjectCountClient> findMaxProjectsClient() {
        List<MaxProjectCountClient> list = new ArrayList<>();
        String sql = getSqlRequest("./sql/find_max_projects_client.sql");
        new SqlUtil().executeQuerySql(sql, rs ->
        {
            try {
                while (rs.next()) {
                    MaxProjectCountClient client = new MaxProjectCountClient();
                    client.setName(rs.getString("name"));
                    client.setProjectCount(rs.getInt("project_count"));
                    list.add(client);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        return list;
    }
    public List<LongestProject> findLongestProject(){
        List<LongestProject> list = new ArrayList<>();
        String sql = getSqlRequest("./sql/find_longest_project.sql");
        new SqlUtil().executeQuerySql(sql, rs ->
        {
            try {
                while (rs.next()) {
                    LongestProject project = new LongestProject();
                    project.setName(rs.getString("name"));
                    project.setMonthCount(rs.getInt("month_count"));
                    list.add(project);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        return list;
    }
    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        List<MaxSalaryWorker> list = new ArrayList<>();
        String sql = getSqlRequest("./sql/find_max_salary_worker.sql");
        new SqlUtil().executeQuerySql(sql, rs ->
        {
            try {
                while (rs.next()) {
                    MaxSalaryWorker worker = new MaxSalaryWorker();
                    worker.setName(rs.getString("name"));
                    worker.setSalary(rs.getInt("salary"));
                    list.add(worker);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        return list;
    }
    public List<YoungestEldestWorkers> findYoungestEldestWorkers() {
        List<YoungestEldestWorkers> list = new ArrayList<>();
        String sql = getSqlRequest("./sql/find_youngest_eldest_workers.sql");
        new SqlUtil().executeQuerySql(sql, rs ->
        {
            try {
                while (rs.next()) {
                    YoungestEldestWorkers worker = new YoungestEldestWorkers();
                    worker.setType(rs.getString("type"));
                    worker.setName(rs.getString("name"));
                    worker.setBirthday(rs.getString("birthday"));
                    list.add(worker);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        return list;
    }

}
