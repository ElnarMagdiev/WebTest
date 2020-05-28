package com.magdiev.dao;

import com.magdiev.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionDaoImpl implements QuestionDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public QuestionDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Question> allQuestions() {
        String sql = "SELECT * FROM questions";
        List<Question> listQuestion = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Question.class));

        return listQuestion;
    }

    @Override
    public void add(Question question) {

    }

    @Override
    public void update(int id) {

    }

    @Override
    public void remove(int id) {

    }
}
