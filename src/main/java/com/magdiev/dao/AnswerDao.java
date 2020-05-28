package com.magdiev.dao;

import com.magdiev.models.Answer;
import com.magdiev.models.Question;

import java.util.List;

public interface AnswerDao {
    List<Answer> getAnswersByQuestionId(int questionId);
    List<Answer> allAnswers();
    void add(Answer answer);
    void update(Answer answer);
    void delete(Answer answer);
    Answer getAnswerById(int id);
}
