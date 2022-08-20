package com.example.TD_People.posting;


import com.example.TD_People.config.BaseException;
import com.example.TD_People.posting.model.GetPostingRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.example.TD_People.config.BaseResponseStatus.DATABASE_ERROR;
import java.util.List;

@Service
public class PostingProvider {
    private final PostingDao postingDao;

    @Autowired
    public PostingProvider(PostingDao postingDao) {
        this.postingDao = postingDao;
    }

    // 모든 게시물 조회
    public List<GetPostingRes> getPostingList() throws BaseException {
        try {
            List<GetPostingRes> getPostingListRes = postingDao.getPostingList();
            return getPostingListRes;
        } catch (Exception exception) {
            // 에러가 발생하였다면 : 5006 : DataBase Error입니다.
            throw new BaseException(DATABASE_ERROR);
        }
    }



}
