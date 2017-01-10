package com.quxin.freshfun.api.oceanuser;

import java.util.Map;

/**
 * Created by ziming on 2017/1/9.
 * 数据平台用户体系
 */
public interface OceanUserService {

    /**
     * 用户登录
     * @param userName 用户名
     * @param password 密码
     * @return code：登录状态，1001：登录成功，1005：用户不存在，1006：用户密码有误，1026：用户名为空，1029：密码为空，1030：用户无权限
     */
    Map<String,Object> userLogin(String userName,String password);

    /**
     * 根据用户Id获取用户信息
     * @param userId 用户id
     * @return userId 用户名，password 密码
     */
    Map<String,Object> getUserInfo(Long userId);
}
