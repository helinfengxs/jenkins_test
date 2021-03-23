package com.helinfengxs.service_ucenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.helinfengxs.service_ucenter.entity.UcenterMember;
import com.helinfengxs.service_ucenter.entity.vo.LoginVo;
import com.helinfengxs.service_ucenter.mapper.UcenterMemberMapper;
import com.helinfengxs.service_ucenter.service.UcenterMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.helinfengxs.servicebase.JenkinsTestException;
import com.helinfengxs.utils.JwtUtils;
import com.helinfengxs.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author helinfeng
 * @since 2021-03-23
 */
@Service
public class UcenterMemberServiceImpl extends ServiceImpl<UcenterMemberMapper, UcenterMember> implements UcenterMemberService {

 private  UcenterMemberMapper ucenterMemberMapper;

    /**
     * 登录验证逻辑
     * @param loginVo 登录对象
     */
    @Override
    public String login(LoginVo loginVo) {

        String mobile = loginVo.getMobile();
        String pass = loginVo.getPassword();
        if(StringUtils.isEmpty(mobile) || StringUtils.isEmpty(pass)){
            throw new JenkinsTestException(20001,"登录失败");
        }
        QueryWrapper<UcenterMember> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("mobile",mobile);
        UcenterMember userinfo = baseMapper.selectOne(queryWrapper);
        if(userinfo==null){
            throw new JenkinsTestException(20001,"账号不存在");
        }
        if(!MD5.encrypt(pass).equals(userinfo.getPassword())){
            throw new JenkinsTestException(20001,"登录失败");
        }
        System.out.println(userinfo.getIsDisabled());
        if(userinfo.getIsDisabled()){
            throw new JenkinsTestException(20001,"账号已被禁用");
        }

        return JwtUtils.getJwtToken(userinfo.getId(), userinfo.getNickname());
    }

}
