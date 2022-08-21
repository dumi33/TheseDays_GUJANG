package com.example.TD_People.place;


import com.example.TD_People.place.model.GetPlaceListRes;
import com.example.TD_People.place.model.GetPlaceRes;
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

        String getPlaceQuery = "select placeIdx,placeName,type,region,position,price,tennisType,time,rate,etc from Place";
        return this.jdbcTemplate.query(getPlaceQuery,
                (rs, rowNum) -> new GetPlaceRes(
                        rs.getInt("placeIdx"),
                        rs.getString("placeName"),
                        rs.getString("type"),
                        rs.getString("region"),
                        rs.getString("position"),
                        rs.getInt("price"),
                        rs.getString("tennisType"),
                        rs.getString("time"),
                        rs.getInt("rate"),
                        rs.getString("etc"))

        );
    }

    public GetPlaceRes getPlaceByIdx(int placeIdx) {

        String getPlaceQuery = "select placeIdx,placeName,type,region,position,price,tennisType,time,rate,etc from Place where placeIdx = ?";
        return this.jdbcTemplate.queryForObject(getPlaceQuery,
                (rs, rowNum) -> new GetPlaceRes(
                        rs.getInt("placeIdx"),
                        rs.getString("placeName"),
                        rs.getString("type"),
                        rs.getString("region"),
                        rs.getString("position"),
                        rs.getInt("price"),
                        rs.getString("tennisType"),
                        rs.getString("time"),
                        rs.getInt("rate"),
                        rs.getString("etc")),placeIdx);
    }

}
