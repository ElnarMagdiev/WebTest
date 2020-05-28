package com.magdiev.dao;

import com.magdiev.models.Question;

import java.util.List;

public interface QuestionDao {
    List<Question> allQuestions();
    void add(Question question);
    void update(int id);
    void remove(int id);
}
