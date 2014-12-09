package com.qunar.demo.app.system;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import qunar.web.security.AuthorizationControl;
import qunar.web.security.LoginManager;

@Service
public class AccessControl implements AuthorizationControl {

    @Resource
    private LoginManager<String> loginManager;

    // TODO user manager system
    @SuppressWarnings("serial")
    private static final Set<String> noCheckRequiredPrefix = new HashSet<String>() {
        {
            add("/login.htm");
            add("/api/");
        }
    };

    @Override
    public boolean isCheckRequired(HttpServletRequest _request) {

        String uri = uriOf((HttpServletRequest) _request);

        for (String prefix : noCheckRequiredPrefix) {
            if (uri.startsWith(prefix)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean isAuthorized(HttpServletRequest request) {

        if (!loginManager.isLogin((HttpServletRequest) request)) {
            // not login
            return false;
        }

        String loginId = loginManager.current(request);
        String uri = uriOf((HttpServletRequest) request);
        // TODO check account_uri privileges

        return true;
    }


    private String uriOf(HttpServletRequest request) {
        return request.getRequestURI().replaceFirst(request.getContextPath(), "");
    }
}
