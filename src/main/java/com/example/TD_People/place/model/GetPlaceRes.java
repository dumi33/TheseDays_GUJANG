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
    private String content;
}
