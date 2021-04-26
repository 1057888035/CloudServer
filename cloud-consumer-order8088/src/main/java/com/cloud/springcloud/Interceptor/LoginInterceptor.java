package com.cloud.springcloud.Interceptor;



import com.cloud.springcloud.entities.JwtUtils;
import com.cloud.springcloud.userservice.service.StaffService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    StaffService staffService;

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从 http 请求头中取出 token
        String token = request.getHeader("X-Token");
        // 如果不是映射到方法直接通过
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        if (token != null && redisTemplate.opsForValue().get(JwtUtils.getUserNameByToken(request)) !=null  ){
            System.out.println(redisTemplate.opsForValue().get(JwtUtils.getUserNameByToken(request)));
            String username = JwtUtils.getUserNameByToken(request);
            String password = staffService.getPasswordForPhone(username);
            boolean result = JwtUtils.verify(token,username,password);
            if(result){
                System.out.println("通过拦截器");
                return true;
            }
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
