package com.example.TD_People.reservation.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GetReservationListRes {
    private List<GetReservationRes> reservationList;
}
