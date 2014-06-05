<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="org.springframework.jdbc.core.JdbcTemplate"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<h2>发布check url页面</h2>
验证系统各功能资源工作正常
<%
ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
%>

<h3>DB Test</3>
<%=context.getBean(JdbcTemplate.class).queryForObject("select now()", Date.class) %>