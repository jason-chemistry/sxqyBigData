package com.test.api.mapper;

import org.apache.ibatis.annotations.Param;

public interface DataMapper {

    public  String getLisCount(@Param("today") String today,@Param("nextDay")String nextDay);

    public int getMzCount(@Param("today") String today,@Param("nextDay")String nextDay);

    public int getQYCount(@Param("today") String today,@Param("nextDay")String nextDay);

    public int getSfCount(@Param("today") String today,@Param("nextDay")String nextDay);

}
