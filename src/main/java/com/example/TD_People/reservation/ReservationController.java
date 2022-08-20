package com.example.TD_People.reservation;


import com.example.TD_People.config.BaseException;
import com.example.TD_People.config.BaseResponse;
import com.example.TD_People.reservation.model.GetReservationListRes;
import com.example.TD_People.reservation.model.PostReservationReq;
import com.example.TD_People.reservation.model.PostReservationRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    private final ReservationProvider reservationProvider;
    @Autowired
    private final ReservationService reservationService;

    public ReservationController(ReservationProvider reservationProvider,ReservationService reservationService) {
        this.reservationProvider = reservationProvider;
        this.reservationService = reservationService;
    }

    /**
     * 예약 작성 API
     * [POST] /reservations
     */

    @ResponseBody
    @PostMapping("")
    public BaseResponse<PostReservationRes> createReservation(@RequestBody PostReservationReq postReservationReq) {

        try{
            PostReservationRes postReservationRes = reservationService.createReservation(postReservationReq);
            return new BaseResponse<>(postReservationRes);
        } catch (BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }

    /**
     * 특정 인물의 예약 조회 API
     * [GET] /postings?userIdx=
     *
     * Query String
     */
    @ResponseBody
    @GetMapping("")
    public BaseResponse<GetReservationListRes> getReservationList(@RequestParam("userIdx") int userIdx) {
        // @RequestParam을 통해 파라미터를 입력받는다.
        try {
            //조회 성공 시 : List<GetBlocklistRes> 형태로 결과(차단목록) 반환
            GetReservationListRes getReservationListRes = reservationProvider.getReservationList(userIdx); //조회(read) -> Provider
            return new BaseResponse<>(getReservationListRes);
        } catch (BaseException exception) {
            return new BaseResponse<>((exception.getStatus()));
        }
    }


}
