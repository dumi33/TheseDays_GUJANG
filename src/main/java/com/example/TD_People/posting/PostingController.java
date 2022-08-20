package com.example.TD_People.posting;


import com.example.TD_People.config.BaseException;
import com.example.TD_People.config.BaseResponse;
import com.example.TD_People.posting.model.GetPostingRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/postings")
public class PostingController {
    @Autowired
    private final PostingProvider postingProvider;
    @Autowired
    private final PostingService postingService;

    public PostingController(PostingProvider postingProvider, PostingService postingService) {
        this.postingProvider = postingProvider;
        this.postingService = postingService;
    }

    /**
     * 게시물 목록 전체 조회 API
     * [GET] /postings
     *
     *
     */
    @ResponseBody
    @GetMapping("")
    public BaseResponse<List<GetPostingRes>> getPostingList() {
        try {
            //조회 성공 시 : List<GetBlocklistRes> 형태로 결과(차단목록) 반환
            List<GetPostingRes> getPostingListRes = postingProvider.getPostingList(); //조회(read) -> Provider
            return new BaseResponse<>(getPostingListRes);
        } catch (BaseException exception) {
            return new BaseResponse<>((exception.getStatus()));
        }
    }





}

