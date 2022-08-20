package com.example.TD_People.festival.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor

public class GetFestivalListRes {
    private List<GetFestivalRes> festivalList;

}
