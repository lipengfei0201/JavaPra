package com.qunar.demo.app.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

// 登陆/注销处理
@Controller
public class LoginController {

    @Resource
    private qunar.web.security.SecurityManager securityManager;

    @RequestMapping("/login")
    public ModelAndView login(@RequestParam(value = "token", required = false) String token,
            HttpServletRequest request, HttpServletResponse response) {

        if (securityManager.isLogin(request)) {
            return new ModelAndView("redirect:/hello.htm");
        }

        if (StringUtils.isEmpty(token)) {
            return new ModelAndView("login", "message", "token不能为空");
        }

        String loginId = securityManager.verityLoginToken(token);
        if (StringUtils.isEmpty(loginId)) {
            return new ModelAndView("login", "message", "token无效");
        }

        securityManager.login(loginId, response);
        return new ModelAndView("redirect:/hello.htm");
    }

    @RequestMapping("/logout")
    public String logout(HttpServletResponse response) throws IOException {
        securityManager.logout(response);
        return "redirect:/";
    }
}
