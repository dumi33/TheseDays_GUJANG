package com.example.TD_People.place;


import com.example.TD_People.reservation.ReservationDao;
import com.example.TD_People.reservation.ReservationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceService {
    private final PlaceDao placeDao;
    private final PlaceProvider placeProvider;

    @Autowired
    public PlaceService(PlaceDao placeDao, PlaceProvider placeProvider) {
        this.placeDao = placeDao;
        this.placeProvider = placeProvider;
    }



}
