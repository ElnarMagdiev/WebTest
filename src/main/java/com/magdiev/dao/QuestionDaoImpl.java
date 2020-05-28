package com.magdiev.dao;

import com.magdiev.models.Question;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionDaoImpl implements QuestionDao {

    @Override
    public List<Question> allQuestions() {
        return null;
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
