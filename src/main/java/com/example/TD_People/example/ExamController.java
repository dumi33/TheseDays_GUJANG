package com.example.TD_People.example;


import com.example.TD_People.config.BaseException;
import com.example.TD_People.config.BaseResponse;
import com.example.TD_People.example.model.GetExamRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exams")
public class ExamController {
    @Autowired
    private final ExamProvider examProvider;
    @Autowired
    private final ExamService examService;


    public ExamController(ExamProvider examProvider, ExamService examService) {
        this.examProvider = examProvider;
        this.examService = examService;
    }

    /**
     * 게시물 목록 전체 조회 API
     * [GET] /postings
     *
     *
     */
    @ResponseBody
    @GetMapping("")
    public BaseResponse<List<GetExamRes>> getExamList() {
        try {
            //조회 성공 시 : List<GetBlocklistRes> 형태로 결과(차단목록) 반환
            List<GetExamRes> getExamRes = examProvider.getExamList(); //조회(read) -> Provider
            return new BaseResponse<>(getExamRes);
        } catch (BaseException exception) {
            return new BaseResponse<>((exception.getStatus()));
        }
    }



}
