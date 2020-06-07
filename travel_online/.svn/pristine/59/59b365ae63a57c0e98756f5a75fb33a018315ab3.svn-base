package com.regino.travel.service.impl;

import com.regino.travel.dao.OrderDao;
import com.regino.travel.dao.OrderItemDao;
import com.regino.travel.domain.Order;
import com.regino.travel.domain.OrderItem;
import com.regino.travel.domain.ResultInfo;
import com.regino.travel.service.OrderService;
import com.regino.travel.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.Map;

public class OrderServiceImpl implements OrderService {
    @Override
    public void save(Order order) {
        // 获取代理对象
        SqlSession sqlSession = MyBatisUtils.openSession();
        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
        OrderItemDao orderItemDao = sqlSession.getMapper(OrderItemDao.class);

        // 保存订单
        orderDao.save(order);
        // 保存订单项
        for (OrderItem orderItem : order.getOrderItemList()) {
            orderItemDao.save(orderItem);
        }

        // 关闭对话
        MyBatisUtils.close(sqlSession);
    }

    @Override
    public void updateState(Map<String, String> param) {
        // 获取订单号
        String oid = param.get("out_trade_no");

        // 修改订单状态
        SqlSession sqlSession = MyBatisUtils.openSession();
        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
        OrderItemDao orderItemDao = sqlSession.getMapper(OrderItemDao.class);

        // 修改订单
        orderDao.updateState(oid);
        // 修改订单项
        orderItemDao.updateState(oid);

        // 关闭会话
        MyBatisUtils.close(sqlSession);
    }

    @Override
    public ResultInfo findState(String oid) {
        // 获取代理对象
        SqlSession sqlSession = MyBatisUtils.openSession();
        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);

        ResultInfo resultInfo = null;

        // 查询dao
        Order order = orderDao.findByOid(oid);
        if (order.getState() == 0) {
            resultInfo = new ResultInfo(false); // 未支付
        } else {
            resultInfo = new ResultInfo(true); // 已支付
        }

        // 关闭会话
        MyBatisUtils.close(sqlSession);

        return resultInfo;
    }
}
