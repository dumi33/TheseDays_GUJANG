package com.example.TD_People.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamService {


    private final ExamDao examDao;
    private final ExamProvider examProvider;

    @Autowired
    public ExamService(ExamDao examDao, ExamProvider examProvider) {
        this.examDao = examDao;
        this.examProvider = examProvider;
    }



}
