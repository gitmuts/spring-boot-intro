package com.gitmuts.testmwallet.service;

import com.gitmuts.testmwallet.model.UserLogin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
@Slf4j
public class LoginService {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public String login(UserLogin userLogin){
        try{

            return "token";
        } catch (Exception e){
            return null;
        }
    }

    public List<UserLogin> getUserLogins(){

        String sql = "SELECT * from user_login where active=?";

       return jdbcTemplate.query(sql, new Object[]{1}, new UserLoginMapper());
    }

    private class UserLoginMapper implements RowMapper<UserLogin> {

        @Override
        public UserLogin mapRow(ResultSet rs, int i) throws SQLException {
            UserLogin userLogin = new UserLogin();
            userLogin.setUsername(rs.getString("username"));
            return userLogin;
        }
    }
}
