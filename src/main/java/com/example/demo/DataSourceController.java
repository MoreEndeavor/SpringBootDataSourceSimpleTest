package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DataSourceController {

    @Autowired
    private DataSource dataSource;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("select")
    public List<String> getUsers() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<String> users = new ArrayList<>();
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement("select name from c_user");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String user = resultSet.getString(1);
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @GetMapping("select2")
    public List<String> getUsers2() {
        String sql = "select name from c_user";
        List<String> users = jdbcTemplate.queryForList(sql, String.class);
        return users;
    }
}
