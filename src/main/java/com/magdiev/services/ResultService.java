package com.magdiev.services;

import com.magdiev.models.Result;

import java.util.List;

public interface ResultService {
    void add(Result result);
    List<Result> getResultsByUserId(int id_user);
    List<Result> getAllResults();
    int findBetterResults(int score);
    int findWorseResults(int score);
    List<Result> getCompletedResults();
}
