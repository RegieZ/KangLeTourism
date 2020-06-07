package com.regino.travel.service.impl;

import com.regino.travel.dao.AddressDao;
import com.regino.travel.domain.Address;
import com.regino.travel.service.AddressService;
import com.regino.travel.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AddressServiceImpl implements AddressService {
    @Override
    public List<Address> findByUid(int uid) {
        // 创建代理对象
        SqlSession sqlSession = MyBatisUtils.openSession();
        AddressDao addressDao = sqlSession.getMapper(AddressDao.class);

        // 调用dao
        List<Address> addressList = addressDao.findByUid(uid);

        // 关闭会话
        MyBatisUtils.close(sqlSession);

        return addressList;
    }

    @Override
    public void save(Address param) {
        // 创建代理对象
        SqlSession sqlSession = MyBatisUtils.openSession();
        AddressDao addressDao = sqlSession.getMapper(AddressDao.class);

        // 调用dao
        addressDao.save(param);

        // 关闭会话
        MyBatisUtils.close(sqlSession);
    }

    @Override
    public void deleteByAid(int aid) {
        // 创建代理对象
        SqlSession sqlSession = MyBatisUtils.openSession();
        AddressDao addressDao = sqlSession.getMapper(AddressDao.class);

        // 调用dao
        addressDao.deleteByAid(aid);

        // 关闭会话
        MyBatisUtils.close(sqlSession);
    }

    @Override
    public void clearDefault(int uid) {
        // 创建代理对象
        SqlSession sqlSession = MyBatisUtils.openSession();
        AddressDao addressDao = sqlSession.getMapper(AddressDao.class);

        // 调用dao
        addressDao.clearDefault(uid);

        // 关闭会话
        MyBatisUtils.close(sqlSession);
    }

    @Override
    public void setAsDefault(int aid) {
        // 创建代理对象
        SqlSession sqlSession = MyBatisUtils.openSession();
        AddressDao addressDao = sqlSession.getMapper(AddressDao.class);

        // 调用dao
        addressDao.setAsDefault(aid);

        // 关闭会话
        MyBatisUtils.close(sqlSession);
    }

    @Override
    public void editByAid(Address param) {
        // 创建代理对象
        SqlSession sqlSession = MyBatisUtils.openSession();
        AddressDao addressDao = sqlSession.getMapper(AddressDao.class);

        // 调用dao
        addressDao.editByAid(param);

        // 关闭会话
        MyBatisUtils.close(sqlSession);
    }
}
