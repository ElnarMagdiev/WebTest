package com.magdiev.dao;

import com.magdiev.models.Answer;


import java.util.List;

public interface AnswerDao {
    List<Answer> getAnswersByQuestionId(int questionId);
    List<Answer> allAnswers();
    void add(Answer answer);
    void update(Answer answer);
    void delete(Answer answer);
    Answer getAnswerById(int id);
    int findCorrectAnswerByQuestionId(int id_question);
}
