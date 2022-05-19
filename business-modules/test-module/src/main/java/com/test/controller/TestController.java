package com.test.controller;

import com.alibaba.fastjson.JSONObject;
import com.pub.redis.service.RedisService;
import com.pub.redis.util.RedisCache;
import com.test.entity.MobileUserBlackInfo;
import com.test.service.MobileUserBlackInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private RedisCache redisCache;
    @Autowired
    private MobileUserBlackInfoServiceImpl mobileUserBlackInfoServiceImpl;
        @RequestMapping(value = "getVuid", method = RequestMethod.POST)
        @ResponseBody
        public String testGetLogger(@RequestBody JSONObject req){
            redisCache.setnxWithExptime("gan","yongheng",2000);
            MobileUserBlackInfo byId = mobileUserBlackInfoServiceImpl.getById(1);
            return byId.getVuid();
        }
}
