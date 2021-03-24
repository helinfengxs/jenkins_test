package com.helinfengxs.service_ucenter.client;

import com.helinfengxs.service_ucenter.client.imp.ServiceEduTeacherImpl;
import com.helinfengxs.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@FeignClient(name = "service-edu",fallback = ServiceEduTeacherImpl.class)
@Component
public interface ServiceEduTeacher {


    @GetMapping("teacher/teacherlist/{current}/{limit}")
    public Map<String,Object> getTeachList(@PathVariable("current") long current, @PathVariable("limit") long limit);


}
