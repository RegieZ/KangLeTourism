package com.regino.travel.web.servlet;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.regino.travel.factory.BeanFactory;
import com.regino.travel.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/PayNotify")
public class PayNotify extends HttpServlet {

    private OrderService orderService = (OrderService) BeanFactory.getBean("orderService");

    // 这里只是收到微信端发过来的请求，建议再次发送确认，以防止伪装网站发送了请求（订单、支付成功信息）
    // TODO: 再次发送确认，并对比两次收到的信息是否一致
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接收请求参数（xml）
        ServletInputStream inputStream = request.getInputStream();
        // 将xml转为java对象
        XmlMapper xmlMapper = new XmlMapper();
        Map param = xmlMapper.readValue(inputStream, Map.class);
        // 调用orderService修改订单状态
        orderService.updateState(param);
        // 返回微信平台接收成功
        HashMap<String, String> result = new HashMap<>();
        result.put("return_code", "SUCCESS");
        result.put("return_msg", "OK");
        // 将Map转为xml
        String xml = xmlMapper.writeValueAsString(result);
        response.setContentType("application/xml;charset=utf-8"); // 设置MIME类型为xml，可以省略
        response.getWriter().write(xml);
    }
}
