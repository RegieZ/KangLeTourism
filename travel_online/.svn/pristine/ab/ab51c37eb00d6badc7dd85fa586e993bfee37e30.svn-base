package com.regino.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取客户调用的方法
        String action = request.getParameter("action"); // 获取要调用的方法名
        try {
            // 获取当前类的字节码对象
        /*
          getDeclaredMethod(methodName,Class types)
                参数1：方法名
                参数2：方法的参数类型
         */
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            //执行方法
            //为了防止方法是私有的，可以使用暴力反射
            method.setAccessible(true);
        /*
          invoke(obj,args)
            obj: 调用方法的对象
            args: 调用该方法需要的实参
         */
            method.invoke(this,request,response);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}