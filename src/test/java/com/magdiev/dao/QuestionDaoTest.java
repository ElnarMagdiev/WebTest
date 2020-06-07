package com.magdiev.dao;

import com.magdiev.dao.impl.QuestionDaoImpl;
import com.magdiev.models.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuestionDaoTest {

    private QuestionDao dao;

    @BeforeEach
    void setUp() throws Exception {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/schema_web?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        dao = new QuestionDaoImpl(new JdbcTemplate(dataSource));
    }

    @Test
    void allQuestions() {
        List<Question> list = dao.allQuestions();
        assertTrue(list.isEmpty());
    }

    @Test
    void add() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void getQuestionById() {
    }
}