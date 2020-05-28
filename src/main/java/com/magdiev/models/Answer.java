package com.magdiev.models;

public class Answer {
    private int id;
    private int id_question;
    private String content;
    private boolean isCorrect;

    public Answer(int id, int id_question, String content, boolean isCorrect) {
        this.id = id;
        this.id_question = id_question;
        this.content = content;
        this.isCorrect = isCorrect;
    }

    public Answer(int id_question, String content, boolean isCorrect) {
        this.id_question = id_question;
        this.content = content;
        this.isCorrect = isCorrect;
    }

    public Answer(int id_question, String content) {
        this.id_question = id_question;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_question() {
        return id_question;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
