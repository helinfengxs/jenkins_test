package com.helinfengxs.service_teacher.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.helinfengxs.service_teacher.entity.EduTeacher;
import com.helinfengxs.service_teacher.service.EduTeacherService;
import com.helinfengxs.servicebase.JenkinsTestException;
import com.helinfengxs.utils.JwtUtils;
import com.helinfengxs.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author helinfeng
 * @since 2021-03-23
 */
@RestController
@Api(description = "老师管理")
@RequestMapping("/teacher/")
public class EduTeacherController {
    @Autowired
    private EduTeacherService eduTeacherService;

    @ApiOperation(value = "查询所有老师信息")
    @GetMapping("/teacherlist/{current}/{limit}")
    public Map<String,Object> getTeachList( @PathVariable long current,@PathVariable long limit){
        System.out.println("11111111111111");
//        String token = request.getHeader("token");
//        boolean b = JwtUtils.checkToken(token);
//        if(!b){
//            throw new JenkinsTestException(20001,"用户无权限");
//        }
        Page<EduTeacher> pageTeacher = new Page<>(current,limit);
        Map<String, Object> teachMap =  eduTeacherService.getTeacherList(pageTeacher);
        return teachMap;
    }
     @GetMapping("/testquery")
    public String getString(){
        return "abcd";
     }

}

