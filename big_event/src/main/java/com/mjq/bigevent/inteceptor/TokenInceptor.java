package com.mjq.bigevent.inteceptor;

import com.mjq.bigevent.utils.JwtUtil;
import com.mjq.bigevent.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;


/*
* 拦截器
* implements HandlerInteceptor
* 重写前置拦截方法
* */
@Component
public class TokenInceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String token = request.getHeader("Authorization");
        Map calims = JwtUtil.parseToken(token);
        ThreadLocalUtil.set(calims);
        try {
            JwtUtil.parseToken(token);
            return true;
        } catch (Exception e) {
            response.setStatus(401);
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ThreadLocalUtil.remove();
    }
}
