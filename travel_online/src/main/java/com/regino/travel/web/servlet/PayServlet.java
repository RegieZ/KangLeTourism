package com.regino.travel.web.servlet;

import com.regino.travel.util.PayUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/PayServlet")
public class PayServlet extends BaseServlet {

    // 模板，方便复制
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    // 调用微信平台，生成预交易链接
    protected void createUrl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接收请求参数
        String oid = request.getParameter("oid");
        String price = request.getParameter("price");

        // 调用工具类，生成交易链接
        String pay_url = PayUtils.createOrder(oid, 1); // 设为1分作测试使用

        // 将数据设置到request域
        request.setAttribute("oid", oid);
        request.setAttribute("price", price);
        request.setAttribute("pay_url", pay_url);

        // 转发到支付页面
        request.getRequestDispatcher("/pay.jsp").forward(request, response);
    }


}
