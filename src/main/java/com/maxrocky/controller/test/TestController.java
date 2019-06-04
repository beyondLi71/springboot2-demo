package com.maxrocky.controller.test;

import com.maxrocky.common.utils.page.PageParam;
import com.maxrocky.common.utils.page.PageResult;
import com.maxrocky.service.test.TestService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by beyondLi
 * Date 2019/6/4 14:10
 * Desc .
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Resource
    TestService testService;

    @RequestMapping(value = "/get/info", method = RequestMethod.GET)
    public PageResult getInfo(@ModelAttribute PageParam pageParam) {
        PageResult pageResult = testService.getinfo(pageParam);
        return pageResult;
    }

    @RequestMapping(value = "/err/info", method = RequestMethod.GET)
    public String errInfo() {
        testService.errInfo();
        return "ok";
    }
}
