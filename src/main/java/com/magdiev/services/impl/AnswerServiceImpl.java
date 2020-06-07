package com.magdiev.services.impl;

import com.magdiev.dao.AnswerDao;
import com.magdiev.models.Answer;
import com.magdiev.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@EnableTransactionManagement
public class AnswerServiceImpl implements AnswerService {

    private AnswerDao answerDao;

    @Autowired
    public void setAnswerDao(AnswerDao answerDao) {
        this.answerDao = answerDao;
    }

    @Override
    @Transactional
    public List<Answer> getAnswersByQuestionId(int questionId) {
        return answerDao.getAnswersByQuestionId(questionId);
    }

    @Override
    @Transactional
    public List<Answer> allAnswers() {
        return answerDao.allAnswers();
    }

    @Override
    @Transactional
    public void add(Answer answer) {
        answerDao.add(answer);
    }

    @Override
    @Transactional
    public void update(Answer answer) {
        answerDao.update(answer);
    }

    @Override
    @Transactional
    public void delete(Answer answer) {
        answerDao.delete(answer);
    }

    @Override
    @Transactional
    public Answer getAnswerById(int id) {
        return answerDao.getAnswerById(id);
    }

    @Override
    @Transactional
    public int findCorrectAnswerByQuestionId(int id_question) {
        return answerDao.findCorrectAnswerByQuestionId(id_question);
    }
}
