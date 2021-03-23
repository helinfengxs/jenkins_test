package com.helinfengxs.service_teacher.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.helinfengxs.service_teacher.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author helinfeng
 * @since 2021-03-23
 */
public interface EduTeacherService extends IService<EduTeacher> {

    Map<String, Object> getTeacherList(Page<EduTeacher> page);

}
