package com.example.TD_People.reservation;


import com.example.TD_People.config.BaseException;
import com.example.TD_People.reservation.model.GetReservationListRes;
import com.example.TD_People.reservation.model.GetReservationRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.TD_People.config.BaseResponseStatus.DATABASE_ERROR;

@Service
public class ReservationProvider {
    private final ReservationDao reservationDao;

    @Autowired
    public ReservationProvider(ReservationDao reservationDao) {
        this.reservationDao = reservationDao;
    }


    /**
    *   user별 예약 리스트 조회
    * */
    // 특정 예약 조회
    public GetReservationListRes getReservationList(int userIdx) throws BaseException {
        try {
            List<GetReservationRes> reservationList = reservationDao.getReservationList(userIdx);
            GetReservationListRes getReservationListRes = new GetReservationListRes(reservationList);
            return getReservationListRes;
        } catch (Exception exception) {
            // 에러가 발생하였다면 : 5006 : DataBase Error입니다.
            throw new BaseException(DATABASE_ERROR);
        }
    }

}
