package com.quxin.freshfun.impl.oceanuser;

import com.alibaba.fastjson.JSON;
import com.quxin.freshfun.api.oceanuser.OceanUserService;
import com.quxin.freshfun.dao.OceanUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ziming on 2017/1/9.
 */
@Service("oceanUserService")
public class OceanUserServiceImpl implements OceanUserService{

    @Autowired
    private OceanUserMapper oceanUserMapper;

    /**
     * 用户登录
     * @param userName 用户名
     * @param password 密码
     * @return code：登录状态，1001：登录成功，1005：用户不存在，1006：用户密码有误，1026：用户名为空，1029：密码为空，1030：用户无权限
     */
    @Override
    public Map<String, Object> userLogin(String userName, String password) {
        Integer code = 1001;
        String msg = "登录成功";
        Long userId = 0l;
        if(userName==null||"".equals(userName)){
            code = 1026;
            msg = "用户名为空";
        }else if(password==null||"".equals(password)){
            code = 1029;
            msg = "密码为空";
        }else{
            Map<String,Object> map = oceanUserMapper.selectUserByName(userName);
            System.out.println(JSON.toJSONString(map));
            if(map==null){
                code = 1005;
                msg = "用户不存在";
            }else{
                if(map.get("password").equals(password)){
                    if(map.get("isAdmin")==0){
                        code = 1030;
                        msg = "用户无权限";
                    }else{
                        userId = Long.parseLong(map.get("userId").toString());
                    }
                }else{
                    code = 1006;
                    msg = "用户密码有误";
                }
            }
        }
        Map<String,Object> result = new HashMap<>();
        result.put("code",code);
        result.put("msg",msg);
        result.put("userId",userId);
        return result;
    }

    /**
     * 根据用户Id获取用户信息
     * @param userId 用户id
     * @return userId 用户名，password 密码
     */
    @Override
    public Map<String, Object> getUserInfo(Long userId) {
        if(userId==null){
            return null;
        }
        return oceanUserMapper.selectUserById(userId);
    }
}
