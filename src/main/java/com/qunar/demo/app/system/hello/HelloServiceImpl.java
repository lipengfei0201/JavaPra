package com.qunar.demo.app.system.hello;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.qunar.demo.app.system.AbstractService;

@Service
public class HelloServiceImpl extends AbstractService implements HelloService {

    @Override
    public String sayHi(String name) {

        Assert.hasText(name, "名字不能为空");

        return "Hello, " + name;
    }
}
