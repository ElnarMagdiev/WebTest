package com.magdiev.dao.impl;

import com.magdiev.dao.QuestionDao;
import com.magdiev.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class QuestionDaoImpl implements QuestionDao {


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public QuestionDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Question> allQuestions() {
      String sql = "SELECT * FROM schema_web.questions";
        List<Question> listQuestion = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Question.class));

        return listQuestion;
    }

    @Override
    public void add(Question question) {
        String sql = "INSERT INTO schema_web.questions(content) VALUES (?)";
        jdbcTemplate.update(sql, question.getContent());
    }

    @Override
    public void update(Question question) {
        String sql = "UPDATE schema_web.questions SET content = ? WHERE id = ?";
        jdbcTemplate.update(sql, question.getContent(), question.getId());
    }

    @Override
    public void delete(Question question) {
        String sql = "DELETE FROM schema_web.questions WHERE id = ?";
        jdbcTemplate.update(sql, question.getId());
    }

    @Override
    public Question getQuestionById(int id) {
        String sql = "SELECT * FROM schema_web.questions WHERE id = ?";
        return (Question) jdbcTemplate.queryForObject(sql,
                                                        new Object[]{id},
                                                            BeanPropertyRowMapper.newInstance(Question.class));
    }



}
