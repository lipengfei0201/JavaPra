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

import qunar.web.security.LoginManager;
import qunar.web.security.QssoClient;

// 登陆/注销处理
@Controller
public class LoginController {

    @Resource
    private LoginManager<String> loginManager;

    @RequestMapping("/login")
    public ModelAndView login(@RequestParam(value = "token", required = false) String token,
            HttpServletRequest request, HttpServletResponse response) {

        if (loginManager.isLogin(request)) {
            return new ModelAndView("redirect:/hello.htm");
        }

        if (StringUtils.isEmpty(token)) {
            return new ModelAndView("login", "message", "token不能为空");
        }

        String loginId = QssoClient.verityLoginToken(token);
        if (StringUtils.isEmpty(loginId)) {
            return new ModelAndView("login", "message", "token无效");
        }

        loginManager.login(loginId, response);
        return new ModelAndView("redirect:/hello.htm");
    }

    @RequestMapping("/logout")
    public String logout(HttpServletResponse response) throws IOException {
        loginManager.logout(response);
        return "redirect:/";
    }
}
