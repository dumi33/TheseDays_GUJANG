package com.example.TD_People.posting.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetPostingRes {
    private int postingIdx;
    private String title;
    private String content;
}
