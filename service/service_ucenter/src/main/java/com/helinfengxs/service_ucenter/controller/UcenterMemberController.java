package com.helinfengxs.service_ucenter.controller;



import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.helinfengxs.service_ucenter.client.ServiceEduTeacher;
import com.helinfengxs.service_ucenter.entity.UcenterMember;
import com.helinfengxs.service_ucenter.entity.vo.LoginVo;
import com.helinfengxs.service_ucenter.service.UcenterMemberService;
import com.helinfengxs.servicebase.JenkinsTestException;
import com.helinfengxs.utils.JwtUtils;
import com.helinfengxs.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author helinfeng
 * @since 2021-03-23
 */
@RestController
@RequestMapping("ucenter-member")
@Api(description = "用户管理")
public class UcenterMemberController {
    @Autowired
    private UcenterMemberService ucenterMemberService;
    @Autowired
    private ServiceEduTeacher serviceEduTeacher;
    /**
     * 登录接口
     * @param loginVo 账号密码对象
     * @return 返回token
     */
    @PostMapping("/login")
    @ApiOperation(value = "登录获取token")
    public R login(@RequestBody (required = true) LoginVo loginVo){
        String token = ucenterMemberService.login(loginVo);
        return R.ok().data("token",token);
    }
    @GetMapping("/getUserInfo")
    @ApiOperation(value = "根据token获取用户信息")
    public R getUserInfo(HttpServletRequest request){
        String userToken = JwtUtils.getMemberIdByJwtToken(request);

        boolean isToken = JwtUtils.checkToken(request.getHeader("token"));
        if (!isToken){
            throw new JenkinsTestException(20001,"用户无权限");
        }
        return R.ok();
    }
    @GetMapping("/getAllUserInfo/{current}/{limit}")
    @ApiOperation(value = "查询所有用户信息以及老师信息")
    public R getAllInfo(@PathVariable long current,@PathVariable long limit){
        Page<UcenterMember> memberPage = new Page<>(current,limit);
        Map<String, Object> teachList = serviceEduTeacher.getTeachList(current, limit);
        return R.ok().data("teacherList",teachList);
    }
}

