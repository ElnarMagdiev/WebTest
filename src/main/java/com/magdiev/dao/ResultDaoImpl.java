package com.magdiev.dao;

import com.magdiev.models.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ResultDaoImpl implements ResultDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ResultDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(Result result) {

    }

    @Override
    public List<Result> getResultsByUserId(int id_user) {

        return null;
    }

    @Override
    public List<Result> getAllResults() {
        return null;
    }
}
