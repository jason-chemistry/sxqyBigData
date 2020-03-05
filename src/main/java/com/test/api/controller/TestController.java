package com.test.api.controller;


import com.alibaba.fastjson.JSONObject;
import com.test.api.service.MZVisitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Api(description = "中转页面")
@Controller
@RequestMapping(value="/turnToIndex")
public class TestController {

    @RequestMapping(value = "")
    @ApiOperation(value = "中转页面接口", notes = "无需参数")
    public String turnToIndex (){
        return "index";
    }

}