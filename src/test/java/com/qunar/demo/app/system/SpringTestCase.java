package com.qunar.demo.app.system;

import junit.framework.TestCase;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/dao.xml", "classpath:spring/service.xml" })
public abstract class SpringTestCase extends TestCase {

}
