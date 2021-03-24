package com.helinfengxs.service_ucenter.client.imp;

import com.helinfengxs.service_ucenter.client.ServiceEduTeacher;
import com.helinfengxs.servicebase.JenkinsTestException;
import com.helinfengxs.utils.R;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ServiceEduTeacherImpl implements ServiceEduTeacher {
    @Override
    public Map<String, Object> getTeachList(long current, long limit) {
        Map<String,Object> map = new HashMap<>();
        map.put("code",20001);
        return map;

    }
}
