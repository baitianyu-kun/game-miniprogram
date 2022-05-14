package com.hebeu.miniprogram.security;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.hebeu.miniprogram.aop.WebLogAspect;
import com.hebeu.miniprogram.entity.ErrorInfo;
import com.hebeu.miniprogram.status.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Configuration
public class WebSessionInterceptor implements HandlerInterceptor {

    private final static Logger logger = LoggerFactory.getLogger(WebLogAspect.class);
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map restParam = (Map) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        printLogBefore(request, response, restParam);
        WebSessionContext webSessionContext = WebSessionContext.getInstance();
        if (restParam==null||webSessionContext.getSession((String) restParam.get("sessionId")) == null) {
            needLoginResponse(request, response);
            return false;
        } else {
            return true;
        }
    }


    private void printLogBefore(HttpServletRequest request, HttpServletResponse response, Map restParam) {

        // 打印请求相关参数
        logger.info("========================================== Start ==========================================");
        // 打印请求 url
        logger.info("URL            : {}", request.getRequestURL().toString());
        // 打印 Http method
        logger.info("HTTP Method    : {}", request.getMethod());
        // 打印请求的 IP
        logger.info("IP             : {}", request.getRemoteAddr());
        // 打印请求入参
        String requestArgs = "";
        if (restParam != null) {
            requestArgs = JSON.toJSONString(restParam);
        }
        logger.info("Request Args  : {}", requestArgs);
    }

    private void needLoginResponse(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            ErrorInfo errorInfo = new ErrorInfo(StatusCode.NEED_LOGIN, "PERMISSION DENIED, PLEASE LOGIN FIRST");
            response.getWriter().print(JSON.toJSONString(errorInfo));
            printLogAfter(request, response, errorInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printLogAfter(HttpServletRequest request, HttpServletResponse response, Object object) {
        logger.info("Response       : {}", JSON.toJSONString(object));
        logger.info("=========================================== End ===========================================" + LINE_SEPARATOR);

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
