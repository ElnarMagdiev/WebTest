package com.magdiev.services.impl;

import com.magdiev.dao.QuestionDao;
import com.magdiev.models.Question;
import com.magdiev.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@EnableTransactionManagement
public class QuestionServiceImpl implements QuestionService {

    private QuestionDao questionDao;

    @Autowired
    public void setQuestionDao(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Override
    @Transactional
    public List<Question> allQuestions() {
        return questionDao.allQuestions();
    }

    @Override
    @Transactional
    public void add(Question question) {
        questionDao.add(question);
    }

    @Override
    @Transactional
    public void update(Question question) {
        questionDao.update(question);
    }

    @Override
    @Transactional
    public void delete(Question question) {
        questionDao.delete(question);
    }

    @Override
    @Transactional
    public Question getQuestionById(int id) {
        return questionDao.getQuestionById(id);
    }
}
