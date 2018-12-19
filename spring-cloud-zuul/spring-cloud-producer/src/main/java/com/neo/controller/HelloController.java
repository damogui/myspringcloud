package com.neo.controller;

import com.neo.controller.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(allowCredentials="true", allowedHeaders="*", methods={RequestMethod.GET,RequestMethod.POST}, origins="*")
public class HelloController {
    private final Logger logger = LoggerFactory.getLogger(FallbackProvider.class);

    @RequestMapping("/hello")
    public String index(@RequestParam(value ="name" ,required = false) String name) {
        logger.info("request one  name is "+name);
        return "hello6666 "+name+"，this is first messge";
    }

    @RequestMapping("/getUser")
    public User getUser(@RequestBody User user) {
        logger.info(user.getName());
        user.setAge(12);
        return user;
    }
}