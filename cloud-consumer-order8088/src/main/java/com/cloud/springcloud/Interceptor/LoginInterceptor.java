package com.cloud.springcloud.Interceptor;



import cn.hutool.json.JSONObject;
import com.cloud.springcloud.entities.CommonResult;
import com.cloud.springcloud.entities.JwtUtils;
import com.cloud.springcloud.entities.entity.Staff;
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
import java.io.PrintWriter;


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
            String username = JwtUtils.getUserNameByToken(request);
            String password = staffService.getPasswordForPhone(username);
            boolean result = JwtUtils.verify(token,username,password);
            Staff staff = staffService.loginin(username, password);
            if(result && staff.getSType()==0){
              return true;
            }
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        JSONObject res = new JSONObject();
        res.put("code",50008);
        res.put("success", false);
        res.put("message", "登录状态已经失效，请重新登录");
        out = response.getWriter();
        out.append(res.toString());

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
