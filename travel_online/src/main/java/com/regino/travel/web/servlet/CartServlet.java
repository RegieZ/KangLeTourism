package com.regino.travel.web.servlet;

import com.regino.travel.domain.Cart;
import com.regino.travel.domain.CartItem;
import com.regino.travel.domain.Route;
import com.regino.travel.domain.User;
import com.regino.travel.factory.BeanFactory;
import com.regino.travel.service.RouteService;
import com.regino.travel.util.CartUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;

@WebServlet("/CartServlet")
public class CartServlet extends BaseServlet {

    // 用到了RouteService的方法
    private RouteService routeService = (RouteService) BeanFactory.getBean("routeService");

    // 模板，方便复制
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    // 添加购物车
    protected void addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接收请求参数
        String num = request.getParameter("num");
        String rid = request.getParameter("rid");

        // 从redis中获取购物车
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        Cart cart = CartUtils.getCartFromRedis(currentUser);

        // 判断当前商品的购物项是否存在
        LinkedHashMap<String, CartItem> cartItemMap = cart.getCartItemMap();
        CartItem cartItem = cartItemMap.get(rid);
        if (cartItem != null) { // 存在购物项
            // 数量累加
            cartItem.setNum(cartItem.getNum() + Integer.parseInt(num));
        } else { // 不存在购物项
            // 根据rid查询route对象
            Route route = routeService.findDetail(rid);
            // 创建购物项对象
            cartItem = new CartItem();
            cartItem.setNum(Integer.parseInt(num));
            cartItem.setRoute(route);
            // 设置到购物车中
            cartItemMap.put(rid, cartItem);
        }

        // 将购物车更新到redis中
        CartUtils.setCartToRedis(currentUser, cart);

        // 将购物项设置到request域，展示给用户
        request.setAttribute("cartItem", cartItem);

        // 转发到添加成功页面
        request.getRequestDispatcher("/cart_success.jsp").forward(request, response);
    }

    // 查看购物车
    protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从session中获取user
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        // 从redis中获取cart
        Cart cart = CartUtils.getCartFromRedis(currentUser);
        // 设置到request域
        request.setAttribute("cart", cart);
        // 转发到cart.jsp
        request.getRequestDispatcher("/cart.jsp").forward(request, response); // "/"不能省略
    }

    // 删除购物项
    protected void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求参数
        String rid = request.getParameter("rid");
        // 获取session中user
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        // 获取redis中cart
        Cart cart = CartUtils.getCartFromRedis(currentUser);
        // 删除购物项
        cart.getCartItemMap().remove(rid);
        // 将cart更新到redis中
        CartUtils.setCartToRedis(currentUser, cart);
        // 重定向查看购物车
        response.sendRedirect(request.getContextPath() + "/CartServlet?action=findAll");
    }
}
