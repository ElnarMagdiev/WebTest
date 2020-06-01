package com.magdiev.models;

import java.util.List;

public class Question {
    private int id;
    private String content;
    private List<Answer> answers;

    public Question(int id, String content) {
        this.id = id;
        this.content = content;
    }


    public Question(String content) {
        this.content = content;
    }

    public Question(String content, List<Answer> answers) {
        this.content = content;
        this.answers = answers;
    }

    public Question() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
