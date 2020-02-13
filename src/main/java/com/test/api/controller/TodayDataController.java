package com.test.api.controller;


import com.alibaba.fastjson.JSONObject;
import com.test.api.service.MZVisitService;
import com.test.api.service.TodayDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "获取今日数据接口")
@RestController
@RequestMapping(value="/TodayDay")
public class TodayDataController {

    @Autowired
    TodayDataService todayDataService;
    @ResponseBody
    @RequestMapping(value = "",method = RequestMethod.GET)
    @ApiOperation(value = "获取今日全部参数", notes = "无需参数")
    public String getAllData (){
        return JSONObject.toJSONString(todayDataService.getAllData());
    }
    @ResponseBody
    @RequestMapping(value = "/zyPeople",method = RequestMethod.GET)
    @ApiOperation(value = "获取住院人数", notes = "无需参数")
    public String getZyPeople (){
        return JSONObject.toJSONString(todayDataService.getZyPeople());

    }
    @ResponseBody
    @RequestMapping(value = "/inPeople",method = RequestMethod.GET)
    @ApiOperation(value = "获取今日入院人数", notes = "无需参数")
    public String getInPeople (){
        return JSONObject.toJSONString(todayDataService.getInPeople());

    }









}