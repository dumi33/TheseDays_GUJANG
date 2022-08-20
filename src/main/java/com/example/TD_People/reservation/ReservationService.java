package com.example.TD_People.reservation;


import com.example.TD_People.config.BaseException;
import com.example.TD_People.reservation.model.PostReservationReq;
import com.example.TD_People.reservation.model.PostReservationRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.example.TD_People.config.BaseResponseStatus.DATABASE_ERROR;



@Service
public class ReservationService {
    private final ReservationDao reservationDao;
    private final ReservationProvider reservationProvider;

    @Autowired
    public ReservationService(ReservationDao reservationDao, ReservationProvider reservationProvider) {
        this.reservationDao = reservationDao;
        this.reservationProvider = reservationProvider;
    }

    // 게시물 작성(POST)
    public PostReservationRes createReservation(PostReservationReq postReservationReq) throws BaseException {

        try {
            int reservationIdx = reservationDao.createReservation(postReservationReq);
            // UserReservation 데이터 추가
            reservationDao.createUserReservation(reservationIdx);
            return new PostReservationRes(reservationIdx);
        } catch (Exception exception) {
            //5006_DataBase Error입니다.
            throw new BaseException(DATABASE_ERROR);
        }
    }

}
