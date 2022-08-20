package com.example.TD_People.festival.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class GetFestivalRes {
    private int festivalIdx;
    private String imgUrl;
    private String festivalName;
    private String univName;
    private String themeName;
    private String date;
    private String endDate;
}
