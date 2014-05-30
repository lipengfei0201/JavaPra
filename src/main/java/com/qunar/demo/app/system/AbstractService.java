package com.qunar.demo.app.system;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractService {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    protected SqlSession sqlSession;
}
