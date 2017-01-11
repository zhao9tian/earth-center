package com.quxin.freshfun.test;

import com.alibaba.fastjson.JSON;
import com.quxin.freshfun.api.oceanuser.OceanUserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ASus on 2017/1/9.
 */
public class OceanUserTest extends TestBase{
    private OceanUserService oceanUserService;
    Logger logger = LoggerFactory.getLogger(OceanUserTest.class);
    @Before
    public void setUp() throws Exception {
        oceanUserService = getContext().getBean("oceanUserService", OceanUserService.class);
    }

    @After
    public void tearDown() throws Exception {
        getContext().close();
    }

    @Test
    public void test(){
        logger.error("测试日志");
//        System.out.print(JSON.toJSONString(oceanUserService.userLogin("yuexuan","0ba201b1099d8c1c7d7e768998b088d1")));
    }
}
