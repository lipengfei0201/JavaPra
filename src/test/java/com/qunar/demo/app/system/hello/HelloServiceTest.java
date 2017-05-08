package com.qunar.demo.app.system.hello;

import javax.annotation.Resource;

import org.junit.Test;

import com.qunar.demo.app.system.SpringTestCase;

public class HelloServiceTest extends SpringTestCase {

    @Resource
    private HelloService service;

    @Test
    public void testSayHi() {
        assertEquals("Hello, world", service.sayHi("world"));
    }
}
