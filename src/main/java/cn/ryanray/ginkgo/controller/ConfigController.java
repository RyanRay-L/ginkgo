package cn.ryanray.ginkgo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("config")
public class ConfigController {

    @Value("${author:nobody}")
//    @Value("${author.name}")
    private String userName;

    @RequestMapping(value = "/getName", method = RequestMethod.GET)
    public String getName() {
//        return "Ryan";
        return "Hello," + userName + "!";
    }

}
