package com.example.TD_People.example;


import com.example.TD_People.config.BaseException;
import com.example.TD_People.example.model.GetExamRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.TD_People.config.BaseResponseStatus.DATABASE_ERROR;

@Service
public class ExamProvider {

    private final ExamDao examDao;

    @Autowired
    public ExamProvider(ExamDao examDao) {
        this.examDao = examDao;
    }

    // 모든 게시물 조회
    public List<GetExamRes> getExamList() throws BaseException {
        try {
            List<GetExamRes> getExamListRes = examDao.getExamList();
            return getExamListRes;
        } catch (Exception exception) {
            // 에러가 발생하였다면 : 5006 : DataBase Error입니다.
            throw new BaseException(DATABASE_ERROR);
        }
    }

}
