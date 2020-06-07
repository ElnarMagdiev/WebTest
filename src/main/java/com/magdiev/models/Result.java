package com.magdiev.models;

public class Result {
    private int id;
    private int id_user;
    private int score;
    private boolean completed;

    public Result(int id, int id_user, int score, boolean completed) {
        this.id = id;
        this.id_user = id_user;
        this.score = score;
        this.completed = completed;
    }

    public Result(int id_user, int score, boolean completed) {
        this.id_user = id_user;
        this.score = score;
        this.completed = completed;
    }

    public Result(int id_user, int score) {
        this.id_user = id_user;
        this.score = score;
        this.completed = false;
    }

    public Result() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
