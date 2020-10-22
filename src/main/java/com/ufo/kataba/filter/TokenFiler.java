package com.ufo.kataba.filter;

import com.ufo.kataba.config.RedisKeyConfig;
import com.ufo.kataba.config.SystemConfig;
import com.ufo.kataba.third.JedisUtil;
import com.ufo.kataba.util.StrUtil;
import com.ufo.kataba.vo.R;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/22 16:05
 * description:过滤器
 */
@WebFilter("/*")
@Component
public class TokenFiler implements Filter {
    private String[] urls ={
            "sendrcode.do",
            "checkrcode.do",
            "checkphone.do",
            "checknickname.do",
            "register.do",
            "login.do",
            "doc.html",
            "/favicon.ico",
            "swagger-resources/configuration/ui",
            "swagger-resources",
            "v2/api-docs"
    };

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            //1.获取请求路径
        HttpServletRequest request =(HttpServletRequest)servletRequest;
        String url = request.getRequestURI();
        boolean r = false;
        for (String s : urls) {
            if (url.endsWith(s)){
                r = true;
                break;
            }
        }
        if (r) {
            //放行
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            //拦截
            HttpServletResponse response = (HttpServletResponse)servletResponse;
            response.setContentType("application/json;charset=UTF-8");
            //是否携带令牌
            String token = request.getHeader(SystemConfig.TOKEN_HEADER);
             if (StrUtil.checkNoEmpty(token)){

                //有令牌 验证令牌是否有效
                 String k =RedisKeyConfig.LOGIN_TOKEN+token;
                 String u =JedisUtil.getInstance().STRINGS.get(k);
                 if ( u!=null) {
                     //更新令牌的有效期
                     JedisUtil.getInstance().expire(k,RedisKeyConfig.LOGIN_TIME);
                     JedisUtil.getInstance().expire(RedisKeyConfig.LOGIN_USER+new JSONObject(u).getInt("id"),RedisKeyConfig.LOGIN_TIME);
                     //令牌有效
                     filterChain.doFilter(servletRequest, servletResponse);
                 }else {
                        response.getWriter().print(new JSONObject(R.fail("令牌已失效")));
                 }
             }else {
                 response.getWriter().print(new JSONObject(R.fail("令牌未传递")));
             }
        }
    }
}
