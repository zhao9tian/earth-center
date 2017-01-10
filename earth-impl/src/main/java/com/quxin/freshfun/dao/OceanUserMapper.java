package com.quxin.freshfun.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * Created by ziming on 2017/1/9.
 */
public interface OceanUserMapper {

    /**
     * 根据用户名获取用户信息
     * @param userName 用户名（帐号）
     * @return 用户信息
     */
    Map<String,Object> selectUserByName(@Param("userName")String userName);

    /**
     * 根据用户id获取用户信息
     * @param userId 用户id
     * @return 用户信息
     */
    Map<String,Object> selectUserById(@Param("userId")Long userId);
}
