package com.magdiev.dao;

import com.magdiev.models.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class AnswerDaoImpl implements AnswerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AnswerDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Answer> getAnswersByQuestionId(int questionId) {
        String sql = "SELECT * FROM schema_web.answers WHERE id_question = ?";
        List<Answer> answerList = new ArrayList<Answer>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, questionId);
        for (Map row: rows) {
            Answer answer = new Answer();
            answer.setId((Integer) row.get("id"));
            answer.setContent((String)row.get("content"));
            answer.setCorrect((Boolean) row.get("isCorrect"));
            answer.setId_question((Integer)row.get("id_question"));
            answerList.add(answer);
        }
        return answerList;
    }

    @Override
    public List<Answer> allAnswers() {
        String sql = "SELECT * FROM schema_web.answers";
        List<Answer> listAnswers = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Answer.class));

        return listAnswers;

    }

    @Override
    public void add(Answer answer) {
        String sql = "INSERT INTO schema_web.answers(id, content, id_question" +
                ", isCorrect) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql, answer.getId(), answer.getContent()
                , answer.getId_question(), answer.getCorrect());
    }

    @Override
    public void update(Answer answer) {
        String sql = "UPDATE schema_web.answers SET content = ?, id_question = ?, " +
                "isCorrect = ? WHERE id = ?";
        jdbcTemplate.update(sql, answer.getContent(), answer.getId_question(), answer.getCorrect(), answer.getId());
    }

    @Override
    public void delete(Answer answer) {
        String sql = "DELETE FROM schema_web.answers WHERE id = ?";
        jdbcTemplate.update(sql, answer.getId());
    }

    @Override
    public Answer getAnswerById(int id) {
        String sql = "SELECT * FROM schema_web.answers WHERE id = ?";
        return (Answer) jdbcTemplate.queryForObject(sql,
                new Object[]{id},
                BeanPropertyRowMapper.newInstance(Answer.class));
    }

    @Override
    public int findCorrectAnswerByQuestionId(int id_question) {

        for (Answer answer: getAnswersByQuestionId(id_question)) {
            if (answer.getCorrect()) {
                return answer.getId();
            }
        }
        return -1;
    }
}
