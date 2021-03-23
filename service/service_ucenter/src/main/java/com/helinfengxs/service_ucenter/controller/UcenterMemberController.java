package com.helinfengxs.service_ucenter.controller;


import com.helinfengxs.service_ucenter.entity.UcenterMember;
import com.helinfengxs.service_ucenter.entity.vo.LoginVo;
import com.helinfengxs.service_ucenter.service.UcenterMemberService;
import com.helinfengxs.servicebase.JenkinsTestException;
import com.helinfengxs.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.jar.JarException;

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
    @Autowired
    private UcenterMemberService ucenterMemberService;


    @PostMapping("/login")
    @ApiOperation(value = "登录获取token")
    public R login(@RequestBody LoginVo loginVo){
        ucenterMemberService.login(loginVo);
        return R.ok().data("token","xs123ad132afdwqe13212");
    }
}

