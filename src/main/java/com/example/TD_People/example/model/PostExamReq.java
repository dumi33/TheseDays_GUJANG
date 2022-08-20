package com.example.TD_People.example.model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostExamReq {
    private int postingIdx;  // 게시물 식별자
    private int categoryIdx; // 카테고리 식별자
    private String title;  //  게시글 제목
    private String content;  // 게시글 내용

}
