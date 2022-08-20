package com.example.TD_People.festival;

import com.example.TD_People.config.BaseException;
import com.example.TD_People.config.BaseResponseStatus;
import com.example.TD_People.festival.model.GetFestivalByFestivalIdxRes;
import com.example.TD_People.festival.model.GetFestivalListRes;
import com.example.TD_People.festival.model.GetFestivalRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FestivalProvider {
    private final FestivalRepository festivalRepository;

    @Autowired
    public FestivalProvider(FestivalRepository festivalRepository) {
        this.festivalRepository = festivalRepository;
    }

    public GetFestivalListRes getFestivalList() throws BaseException {

        try {
            List<GetFestivalRes> festivalList = festivalRepository.getAllFestivalList();
            GetFestivalListRes getFestivalListRes = new GetFestivalListRes(festivalList);
            return getFestivalListRes;
        } catch (Exception e) {
            throw new BaseException(BaseResponseStatus.DATABASE_ERROR);
        }


    }

    public GetFestivalByFestivalIdxRes getFestivalByFestivalIdx(int festivalIdx) throws BaseException {
        try {
            GetFestivalByFestivalIdxRes getFestivalByFestivalIdxRes = festivalRepository.getFestivalInfo(festivalIdx);
            return getFestivalByFestivalIdxRes;
        } catch (Exception e) {
            throw new BaseException(BaseResponseStatus.DATABASE_ERROR);
        }
    }

}
