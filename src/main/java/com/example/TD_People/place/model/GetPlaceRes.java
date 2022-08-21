package com.example.TD_People.place.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetPlaceRes {
    private int placeIdx;
    private String placeName;
    private String type;
    private String region;
    private String position;
    private int price ;
    private String tennisType;
    private String time;
    private int rate;
    private String etc;
}
