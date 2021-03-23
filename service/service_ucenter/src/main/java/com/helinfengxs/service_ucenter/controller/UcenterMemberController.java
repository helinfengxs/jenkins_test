package com.helinfengxs.service_ucenter.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author helinfeng
 * @since 2021-03-23
 */
@RestController
@RequestMapping("ucenter-member")
@Api(description = "用户管理接口")
public class UcenterMemberController {
    @GetMapping("/login")
    @ApiOperation(value = "登录获取token")
    public String login(){
        return "login is successful";
    }
}

