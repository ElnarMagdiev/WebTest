package com.magdiev.services;

import com.magdiev.models.Question;
import java.util.List;

public interface QuestionService {
    List<Question> allQuestions();
    void add(Question question);
    void update(Question question);
    void delete(Question question);
    Question getQuestionById(int id);
}
