package com.qunar.demo.app.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.qunar.demo.app.system.hello.HelloService;

import qunar.web.spring.annotation.JsonBody;

@Controller
public class HelloController {

    @Resource
    private HelloService helloService;

    @RequestMapping("hello")
    public ModelAndView hello() {
        return new ModelAndView("hello/hello").addObject("name", "world");
    }

    @RequestMapping("ex")
    public ModelAndView ex() {
        throw new RuntimeException("测试异常");
    }

    @RequestMapping("sayhi")
    @JsonBody
    public Object sayhi(@RequestParam("name") String name) {
        return helloService.sayHi(name);
    }
}