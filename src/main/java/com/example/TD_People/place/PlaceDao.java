package com.example.TD_People.place;


import com.example.TD_People.place.model.GetPlaceListRes;
import com.example.TD_People.place.model.GetPlaceRes;
import com.example.TD_People.posting.model.GetPostingRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class PlaceDao {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public List<GetPlaceRes> getPlaceList() {

        String getPlaceQuery = "select placeIdx,placeName,content from Place";
        return this.jdbcTemplate.query(getPlaceQuery,
                (rs, rowNum) -> new GetPlaceRes(
                        rs.getInt("placeIdx"),
                        rs.getString("placeName"),
                        rs.getString("content"))

        );
    }

}
