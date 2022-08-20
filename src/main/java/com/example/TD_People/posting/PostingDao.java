package com.example.TD_People.posting;


import com.example.TD_People.posting.model.GetPostingRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class PostingDao {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // Posting 테이블에 존재하는 전체 게시물들 조회
    public List<GetPostingRes> getPostingList() {

        String getNoticesQuery = "select postingIdx,title,content from Posting";
        return this.jdbcTemplate.query(getNoticesQuery,
                (rs, rowNum) -> new GetPostingRes(
                        rs.getInt("postingIdx"),
                        rs.getString("title"),
                        rs.getString("content"))
        );
    }


}
