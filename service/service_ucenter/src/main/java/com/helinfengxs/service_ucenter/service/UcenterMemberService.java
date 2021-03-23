package com.helinfengxs.service_ucenter.service;

import com.helinfengxs.service_ucenter.entity.UcenterMember;
import com.baomidou.mybatisplus.extension.service.IService;
import com.helinfengxs.service_ucenter.entity.vo.LoginVo;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author helinfeng
 * @since 2021-03-23
 */
public interface UcenterMemberService extends IService<UcenterMember> {

    String  login(LoginVo loginVo);
}
