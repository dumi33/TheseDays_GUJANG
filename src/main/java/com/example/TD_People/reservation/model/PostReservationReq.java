package com.example.TD_People.reservation.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PostReservationReq {
    private int placeIdx;
    private String reservationStartTime;
    private String reservationEndTime;
    private String phoneNumber;
    private int headCount;
}

