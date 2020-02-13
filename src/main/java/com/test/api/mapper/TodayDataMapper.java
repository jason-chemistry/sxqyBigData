package com.test.api.mapper;


import com.test.api.model.MZVisit;
import com.test.api.model.TodayData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TodayDataMapper {

    String  getZyPeople();

    String getInPeople();


}
