package com.test.api.controller;


import com.alibaba.fastjson.JSONObject;
import com.test.api.service.RequestService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@Api(description = "获取预约类型接口")
@RestController
@RequestMapping(value="/Requests")
public class RequestController {

    @Autowired
    RequestService requestService;

    @ResponseBody
    @RequestMapping(value = "/requestType",method = RequestMethod.GET)
    @ApiOperation(value = "获取预约类型", notes = "无需参数")
    public String getRequests (){
        return JSONObject.toJSONString(requestService.getRequest());
    }


    @ResponseBody
    @RequestMapping(value = "/allRequest",method = RequestMethod.GET)
    @ApiOperation(value = "获取预约总人数", notes = "无需参数")
    public String getALLRequests (){
        return JSONObject.toJSONString(requestService.getTodayAllRequest());
    }







}