package com.magdiev.models;

import java.util.HashSet;
import java.util.Set;

public class Question {
    private int id;
    private String content;
    private Set<Answer> answers = new HashSet<>();

    public Question(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public Question(String content) {
        this.content = content;
    }

    public Question(String content, Set<Answer> answers) {
        this.content = content;
        this.answers = answers;
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

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }
}
