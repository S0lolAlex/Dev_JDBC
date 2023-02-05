package com.greenSnake;

import sqlRequestUsers.*;

import java.sql.*;
import java.util.*;

public class DatabaseQueryService {

    private Statement createConn()throws SQLException{

        Connection connection = Database.getSinglDb().getConnection();
        return connection.createStatement();
    }

    private ResultSet getSqlRequest(String path)throws SQLException{
        String requestResult = Database.getSinglDb().getRequestResult(path);
        return createConn().executeQuery(requestResult);

    }
    public List<MaxProjectCountClient> findMaxProjectsClient() throws SQLException {
        ResultSet rs = getSqlRequest("./sql/find_max_projects_client.sql");
        List<MaxProjectCountClient> list = new ArrayList<>();
        while(rs.next()) {
            MaxProjectCountClient client = new MaxProjectCountClient();
            client.setName(rs.getString("name"));
            client.setProjectCount(rs.getInt("project_count"));
            list.add(client);
        }
        return list;
    }

    public List<LongestProject> findLongestProject() throws SQLException{
        ResultSet rs = getSqlRequest("./sql/find_longest_project.sql");
        List<LongestProject> list = new ArrayList<>();
        while(rs.next()) {
            LongestProject project = new LongestProject();
            project.setName(rs.getString("name"));
            project.setMonthCount(rs.getInt("month_count"));
            list.add(project);
        }
        return list;
    }
    public List<MaxSalaryWorker> findMaxSalaryWorker() throws SQLException{
        ResultSet rs = getSqlRequest("./sql/find_max_salary_worker.sql");
        List<MaxSalaryWorker> list = new ArrayList<>();
        while(rs.next()) {
            MaxSalaryWorker worker = new MaxSalaryWorker();
            worker.setName(rs.getString("name"));
            worker.setSalary(rs.getInt("salary"));
            list.add(worker);
        }
        return list;
    }
    public List<YoungestEldestWorkers> findYoungestEldestWorkers() throws SQLException{
        ResultSet rs = getSqlRequest("./sql/find_youngest_eldest_workers.sql");
        List<YoungestEldestWorkers> list = new ArrayList<>();
        while(rs.next()) {
            YoungestEldestWorkers worker = new YoungestEldestWorkers();
            worker.setType(rs.getString("type"));
            worker.setName(rs.getString("name"));
            worker.setBirthday(rs.getString("birthday"));
            list.add(worker);
        }
        return list;
    }

}
