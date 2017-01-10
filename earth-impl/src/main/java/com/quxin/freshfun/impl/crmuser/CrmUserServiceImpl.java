package com.quxin.freshfun.impl.crmuser;

import com.quxin.freshfun.api.crmuser.CrmUserService;
import org.springframework.stereotype.Service;

/**
 * Created by ziming on 2017/1/7.
 */
@Service("crmUserService")
public class CrmUserServiceImpl implements CrmUserService {
    @Override
    public String userTest() {
        return "test";
    }
}
