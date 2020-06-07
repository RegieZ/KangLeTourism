package com.regino.travel.web.servlet;

import com.regino.travel.domain.Category;
import com.regino.travel.factory.BeanFactory;
import com.regino.travel.service.AddressService;
import com.regino.travel.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/CategoryServlet")
public class CategoryServlet extends BaseServlet{

    private CategoryService categoryService = (CategoryService) BeanFactory.getBean("categoryService");

    // 模板，方便复制
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    // ajax查询所有
    protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 调用service
        List<Category> categoryList = categoryService.findAll();

        // 转为json，响应到客户端
        javaToJsonWriteClient(categoryList, response);
    }

}
