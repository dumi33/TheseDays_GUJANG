package com.example.TD_People.example;


import com.example.TD_People.example.model.GetExamRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ExamDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // Posting 테이블에 존재하는 전체 게시물들 조회
    public List<GetExamRes> getExamList() {
        String getNoticesQuery = "select examIdx, content from exam";
        return this.jdbcTemplate.query(getNoticesQuery,
                (rs, rowNum) -> new GetExamRes(
                        rs.getInt("examIdx"),
                        rs.getString("content"))
        );
    }


}
