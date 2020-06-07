package com.regino.travel.web.servlet;

import com.regino.travel.domain.Address;
import com.regino.travel.domain.User;
import com.regino.travel.factory.BeanFactory;
import com.regino.travel.service.AddressService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/AddressServlet")
public class AddressServlet extends BaseServlet {

    private AddressService addressService = (AddressService) BeanFactory.getBean("addressService");

    // 模板，方便复制
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    // 根据uid查询地址列表
    protected void findByUid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 校验session中是否有user
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        if (currentUser == null) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            // 重定向可以省略return，请求转发不可以省略return，因为请求转发会继续执行下面的代码
            return;
        }

        // 根据uid查询地址列表
        List<Address> addressList = addressService.findByUid(currentUser.getUid());

        // 设置到request域
        request.setAttribute("addressList", addressList);

        // 请求转发到地址页面
        request.getRequestDispatcher("/home_address.jsp").forward(request, response);
    }

    // 保存收获地址
    protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 校验session中是否有user
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        if (currentUser == null) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            // 重定向可以省略return，请求转发不可以省略return，因为请求转发会继续执行下面的代码
            return;
        }

        try {
            // 接收请求参数
            Map<String, String[]> parameterMap = request.getParameterMap();

            // 封装到address实体中
            Address param = new Address();
            BeanUtils.populate(param, parameterMap);

            // 指定非默认地址
            param.setIsdefault("0");

            // 指定用户
            param.setUser(currentUser); // 注意没有使用过的方法

            // 调用service保存
            addressService.save(param);

            // 重定向
            response.sendRedirect(request.getContextPath() + "/AddressServlet?action=findByUid");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 删除
    protected void deleteByAid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 校验session中是否有user
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        if (currentUser == null) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            // 重定向可以省略return，请求转发不可以省略return，因为请求转发会继续执行下面的代码
            return;
        }

        try {
            // 接收请求参数
            int aid = Integer.valueOf(request.getParameter("aid"));

            // 调用service删除
            addressService.deleteByAid(aid);

            // 重定向
            response.sendRedirect(request.getContextPath() + "/AddressServlet?action=findByUid");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 设为默认地址
    protected void setAsDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 校验session中是否有user
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        if (currentUser == null) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            // 重定向可以省略return，请求转发不可以省略return，因为请求转发会继续执行下面的代码
            return;
        }

        try {
            // 接收请求参数
            int aid = Integer.valueOf(request.getParameter("aid"));

            // 调用service初始化默认地址
            addressService.clearDefault(currentUser.getUid());

            // 调用service设为默认地址
            addressService.setAsDefault(aid);

            // 重定向
            response.sendRedirect(request.getContextPath() + "/AddressServlet?action=findByUid");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 编辑
    protected void editByAid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 校验session中是否有user
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        if (currentUser == null) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            // 重定向可以省略return，请求转发不可以省略return，因为请求转发会继续执行下面的代码
            return;
        }

        try {
            // 接收请求参数
            Map<String, String[]> parameterMap = request.getParameterMap();

            // 封装到address实体中
            Address param = new Address();
            BeanUtils.populate(param, parameterMap);

            // 测试用
            System.out.println(param);

            // 调用service编辑
            addressService.editByAid(param);

            // 重定向
            response.sendRedirect(request.getContextPath() + "/AddressServlet?action=findByUid");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
