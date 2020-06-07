package com.regino.travel.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求方法名（即action参数）
        String action= request.getParameter("action");

        // 获取字节码对象
        Class clazz = this.getClass();

        try{
            // 获取指定名称的方法对象（method对象）
            Method declaredMethod = clazz.getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            // 省略暴力反射（只有private修饰的方法，需要暴力反射）
            // 通过反射调用指定名称的方法
            declaredMethod.invoke(this, request, response);
        } catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("服务器忙..."); // 迷惑行为，其实是未找到该方法
        }
    }

    protected void javaToJsonWriteClient(Object object, HttpServletResponse response) throws ServletException, IOException{
        // 转为Json
        String json= new ObjectMapper().writeValueAsString(object);

        // 通过response响应到客户端
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }
}