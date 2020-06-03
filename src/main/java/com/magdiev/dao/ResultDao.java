package com.magdiev.dao;

import com.magdiev.models.Result;
import com.magdiev.models.User;

import java.util.List;

public interface ResultDao {
    void add(Result result);
    List<Result> getResultsByUserId(int id_user);
    List<Result> getAllResults();

}
