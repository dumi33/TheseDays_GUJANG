package com.example.TD_People.reservation;


import com.example.TD_People.reservation.model.GetReservationListRes;
import com.example.TD_People.reservation.model.GetReservationRes;
import com.example.TD_People.reservation.model.PostReservationReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ReservationDao {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    // 게시물 생성
    public int createReservation(PostReservationReq postReservationReq) {
        String createReservationQuery = "insert into Reservation (placeIdx,reservationStartTime, reservationEndTime, phoneNumber,headCount) VALUES (?,?,?,?,?)";
        Object[] createReservationParams = new Object[]{postReservationReq.getPlaceIdx()
                ,postReservationReq.getReservationStartTime()
                ,postReservationReq.getReservationEndTime()
                ,postReservationReq.getPhoneNumber()
                ,postReservationReq.getHeadCount()
        };
        this.jdbcTemplate.update(createReservationQuery, createReservationParams);

        // 가장 마지막에 삽입된(생성된) blockIdx값을 가져온다.
        String lastInsertIdQuery = "select last_insert_id()";
        return this.jdbcTemplate.queryForObject(lastInsertIdQuery, int.class);
    }

    public void createUserReservation(int resIdx){
        String createUserReservationQuery = "insert into UserReservation (reservationIdx) VALUES (?)";

        this.jdbcTemplate.update(createUserReservationQuery,resIdx);
    }





    // Reservation 테이블에 존재하는 특정 예약들 조회
    public List<GetReservationRes> getReservationList(int userIdx) {
        int paramUserIdx = userIdx;
        String getReservationQuery = "select p.placeName,r.reservationStartTime,r.reservationEndTime, r.headCount " +
                "from UserReservation ur, Place p, Reservation r " +
                "where userIdx = ? and ur.reservationIdx = r.reservationIdx and p.placeIdx = r.placeIdx";

        return this.jdbcTemplate.query(getReservationQuery,
                (rs, rowNum) -> new GetReservationRes(
                        rs.getString("placeName"),
                        rs.getString("reservationStartTime"),
                        rs.getString("reservationEndTime"),
                        rs.getInt("headCount")),paramUserIdx);

    }

}
