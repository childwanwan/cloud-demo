package com.wanpp.learning.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (C), 2020-2020, 思特奇
 * FileName: TestController
 *
 * @Author: wanpp
 * @Date: 2020/1/11 19:45
 * Description:
 * Version: 1.0
 */

@Api(description = "测试接口")
@RestController
@RequestMapping(value = "/test", produces = "application/json;charset=utf-8")
@Slf4j
public class TestController {

    @ApiOperation(value = "测试", httpMethod = "GET", response = String.class, notes = "测试")
    @ApiImplicitParams({})
    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public String test(){
        log.info("正在调用测试接口。。。");
        log.info("调用测试接口成功");
        return "this is second service,the version is 2.0";
    }

}
