package com.regino.travel.web.servlet;

import com.regino.travel.domain.PageBean;
import com.regino.travel.domain.Route;
import com.regino.travel.factory.BeanFactory;
import com.regino.travel.service.RouteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RouteServlet")
public class RouteServlet extends BaseServlet {

    private RouteService routeService = (RouteService) BeanFactory.getBean("routeService");

    // 模板，方便复制
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    // 分页查询
    protected void findByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接收请求参数
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        String cid = request.getParameter("cid"); // 数据库有隐式类型转换，所以不用一定要整型
        String rname = request.getParameter("rname"); // 线路搜索关键字

        // 校验传进来的值是否空值
        if (currentPageStr == null || currentPageStr.equals("")) {
            currentPageStr = "1";
        }
        if (pageSizeStr == null || pageSizeStr.equals((""))) {
            pageSizeStr = "10";
        }

        // 类型转换
        int currentPage = Integer.parseInt(currentPageStr);
        int pageSize = Integer.parseInt(pageSizeStr);

        // 调用service分页查询
        PageBean<Route> pageBean = routeService.findByPage(currentPage, pageSize, cid, rname);

        // 将分页对象设置到request域中
        request.setAttribute("pageBean", pageBean);
        // 将cid设置到request域中
        request.setAttribute("cid", cid);
        // 回显搜索栏中的关键字
        request.setAttribute("rname", rname);

        // 请求转发
        request.getRequestDispatcher("/route_list.jsp").forward(request, response);
    }

    // 线路详情
    protected void routeDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接收请求参数
        String rid = request.getParameter("rid");

        // 调用service查询
        Route route = routeService.findDetail(rid);

        // 设置到request域
        request.setAttribute("route", route);

        // 转发到route_detail.jsp
        request.getRequestDispatcher("/route_detail.jsp").forward(request, response);
    }
}
