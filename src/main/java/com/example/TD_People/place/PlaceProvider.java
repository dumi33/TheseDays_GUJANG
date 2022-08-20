package com.example.TD_People.place;


import com.example.TD_People.config.BaseException;
import com.example.TD_People.place.model.GetPlaceListRes;
import com.example.TD_People.place.model.GetPlaceRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.TD_People.config.BaseResponseStatus.DATABASE_ERROR;

@Service
public class PlaceProvider {
    private final PlaceDao placeDao;

    @Autowired
    public PlaceProvider(PlaceDao placeDao) {
        this.placeDao = placeDao;
    }


    /**
     *   모든 장소 리스트 조회
     *
     * */
    //
    public GetPlaceListRes getPlaceList() throws BaseException {
        try {
            List<GetPlaceRes> getPlaceRes = placeDao.getPlaceList();
            GetPlaceListRes getPlaceListRes = new GetPlaceListRes(getPlaceRes);
            return getPlaceListRes;
        } catch (Exception exception) {
            // 에러가 발생하였다면 : 5006 : DataBase Error입니다.
            throw new BaseException(DATABASE_ERROR);
        }
    }

    /**
     *   IDX별 장소 조회
     * */
    //
    public GetPlaceRes getPlaceByIdx(int placeIdx) throws BaseException {
        try {
            GetPlaceRes getPlaceRes = placeDao.getPlaceByIdx(placeIdx);
            return getPlaceRes;
        } catch (Exception exception) {
            // 에러가 발생하였다면 : 5006 : DataBase Error입니다.
            throw new BaseException(DATABASE_ERROR);
        }
    }


}
