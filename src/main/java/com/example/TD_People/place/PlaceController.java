package com.example.TD_People.place;


import com.example.TD_People.config.BaseException;
import com.example.TD_People.config.BaseResponse;
import com.example.TD_People.place.model.GetPlaceListRes;
import com.example.TD_People.place.model.GetPlaceRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/places")
public class PlaceController {
    @Autowired
    private final PlaceProvider placeProvider;
    @Autowired
    private final PlaceService placeService;

    public PlaceController(PlaceProvider placeProvider, PlaceService placeService) {
        this.placeProvider = placeProvider;
        this.placeService = placeService;
    }


    /**
     * 장소 목록 전체 조회 API
     * [GET] /places
     */
    @ResponseBody
    @GetMapping("")
    public BaseResponse<GetPlaceListRes> getPlaceList() {
        try {
            //조회 성공 시 : List<GetBlocklistRes> 형태로 결과(차단목록) 반환
            GetPlaceListRes getPlaceListRes = placeProvider.getPlaceList(); //조회(read) -> Provider
            return new BaseResponse<>(getPlaceListRes);
        } catch (BaseException exception) {
            return new BaseResponse<>((exception.getStatus()));
        }
    }

    /**
     * 장소 목록 개별 조회 API
     * [GET] /places/{placeIdx}
     */
    @ResponseBody
    @GetMapping("/{placeIdx}")
    public BaseResponse<GetPlaceRes> getPlaceByIdx(@PathVariable int placeIdx) {
        try {
            //조회 성공 시 : List<GetBlocklistRes> 형태로 결과(차단목록) 반환
            GetPlaceRes getPlaceRes = placeProvider.getPlaceByIdx(placeIdx); //조회(read) -> Provider
            return new BaseResponse<>(getPlaceRes);
        } catch (BaseException exception) {
            return new BaseResponse<>((exception.getStatus()));
        }
    }


}
