package com.livre.myhome.interceptor;

import com.livre.myhome.pojo.User;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor { // 拦截器
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        HttpSession session = request.getSession();// 获取session对象
//        String contextPath=session.getServletContext().getContextPath();// 获取URL
//        String[] requireAuthPages = new String[]{// 需要拦截的路径列表
//                "index",
//        };
//
//        String uri = request.getRequestURI();
//
//        uri = StringUtils.remove(uri, contextPath+"/");//截取URL请求
//        String page = uri;
//
//        if(begingWith(page, requireAuthPages)){
//            User user = (User) session.getAttribute("user");
//            if(user==null) {
//                response.sendRedirect("login");
//                return false;
//            }
//        }
//        return true;
        // 放行 options 请求，否则无法让前端带上自定义的 header 信息，导致 sessionID 改变，shiro 验证失败
        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
            response.setStatus(HttpStatus.NO_CONTENT.value());
            return true;
        }

        Subject subject = SecurityUtils.getSubject();
        // 使用 shiro 验证
        if (!subject.isAuthenticated() && !subject.isRemembered()) {
            return false;
        }
        return true;
    }
    private boolean begingWith(String page, String[] requiredAuthPages) {
        boolean result = false;
        for (String requiredAuthPage : requiredAuthPages) {
            if(StringUtils.startsWith(page, requiredAuthPage)) {
                result = true;
                break;
            }
        }
        return result;
    }
}
