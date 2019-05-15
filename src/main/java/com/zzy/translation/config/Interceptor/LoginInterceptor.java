package com.zzy.translation.config.Interceptor;

import com.zzy.translation.config.session.MySessionContext;
import com.zzy.translation.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@Component
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 在请求被处理之前调用
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        if (session == null){
            response.sendRedirect("http://localhost:8086/translation/Pages/login");
            return false;
        }
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser == null){
            response.sendRedirect("http://localhost:8086/translation/Pages/login");
            return false;
        }
        String userName = loginUser.getUserName();
        if (null == userName || "".equals(userName)){
            response.sendRedirect("http://localhost:8086/translation/Pages/login");
            return false;
        }
        return true;
    }

    /**
     * 在请求被处理后，视图渲染之前调用
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 在整个请求结束之后
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
