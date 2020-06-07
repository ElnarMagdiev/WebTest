package com.magdiev.services.impl;

import com.magdiev.dao.ResultDao;
import com.magdiev.models.Result;
import com.magdiev.services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@EnableTransactionManagement
public class ResultServiceImpl implements ResultService {

    private ResultDao resultDao;

    @Autowired
    public void setResultDao(ResultDao resultDao) {
        this.resultDao = resultDao;
    }

    @Override
    @Transactional
    public void add(Result result) {
        resultDao.add(result);
    }

    @Override
    @Transactional
    public List<Result> getResultsByUserId(int id_user) {
        return resultDao.getResultsByUserId(id_user);
    }

    @Override
    @Transactional
    public List<Result> getAllResults() {
        return resultDao.getAllResults();
    }

    @Override
    @Transactional
    public int findBetterResults(int score) {

        return resultDao.findBetterResults(score);
    }

    @Override
    @Transactional
    public int findWorseResults(int score) {
        return resultDao.findWorseResults(score);
    }

    @Override
    @Transactional
    public List<Result> getCompletedResults() {
        return resultDao.getCompletedResults();
    }


}
