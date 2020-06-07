package com.magdiev.dao.impl;

import com.magdiev.dao.ResultDao;
import com.magdiev.models.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
        String sql = "INSERT INTO schema_web.results(id_user, score, completed) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, result.getId_user(), result.getScore(), result.isCompleted());
    }

    @Override
    public List<Result> getResultsByUserId(int id_user) {
        String sql = "SELECT * FROM schema_web.results WHERE id_user=?";
        List<Result> listResult = jdbcTemplate.query(sql, new Object[]{id_user}, BeanPropertyRowMapper.newInstance(Result.class));
        return listResult;
    }

    @Override
    public List<Result> getAllResults() {
        String sql = "SELECT * FROM schema_web.results";
        List<Result> listResult = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Result.class));
        return listResult;
    }

    @Override
    public int findBetterResults(int score) {
        String sql = "SELECT * FROM schema_web.results WHERE score > ?";
        List<Result> listResult = jdbcTemplate.query(sql, new Object[]{score}, BeanPropertyRowMapper.newInstance(Result.class));
        int betterYou = listResult.size();
        int all = getAllResults().size();
        if (betterYou == 0 || all == 0) return 100;

        return (betterYou * 100) / all;
    }

    @Override
    public int findWorseResults(int score) {
        String sql = "SELECT * FROM schema_web.results WHERE score < ?";
        List<Result> listResult = jdbcTemplate.query(sql, new Object[]{score}, BeanPropertyRowMapper.newInstance(Result.class));
        int worseThanYou = listResult.size();
        int all = getAllResults().size();
        if (worseThanYou == 0 || all == 0) return 0;

        return (worseThanYou * 100) / all;
    }

    @Override
    public List<Result> getCompletedResults() {
        String sql = "SELECT * FROM schema_web.results WHERE completed";
        List<Result> listResult = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Result.class));
        return listResult;
    }
}
