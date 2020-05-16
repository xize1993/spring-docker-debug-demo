package com.xavier.dockerDebugDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Xavier
 * @create: 2020-05-09
 **/
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate ;

    private final String KEY = "demo-key";

    @GetMapping("/increase")
    public String increase() {
        String result;

        if (stringRedisTemplate.hasKey(KEY)) {
            String val = stringRedisTemplate.opsForValue().get(KEY);
            result = (Integer.parseInt(val) + 2) + "";
            stringRedisTemplate.opsForValue().set(KEY, result);
        } else {
            stringRedisTemplate.opsForValue().set(KEY, "1");
            result = "1";
        }
        return result;
    }

}
