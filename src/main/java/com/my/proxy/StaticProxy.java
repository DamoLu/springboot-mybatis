package com.my.proxy;

import com.my.mapper.UserMapper;
import com.my.model.User;
import com.my.model.UserExample;
import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: luqihua
 * @CreateDate: 2019/5/3$ 21:01$
 *
 * 静态代理对象，面向接口代理，可代理所有实现该接口的实现类
 * 缺点：需要为每个接口单独写一个代理类
 */
public class StaticProxy implements UserMapper{

    //可以维护任意一个实现了UserMapper接口的实现类
    private UserMapper target;

    public StaticProxy(UserMapper target) {
        this.target = target;
    }

    @Override
    public User selectByPrimaryKey(Integer userId) {
        System.out.println("代理类增强功能");
        return target.selectByPrimaryKey(userId);
    }

    @Override
    public long countByExample(UserExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(UserExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Integer userId) {
        return 0;
    }

    @Override
    public int insert(User record) {
        return 0;
    }

    @Override
    public int insertSelective(User record) {
        return 0;
    }

    @Override
    public List<User> selectByExample(UserExample example) {
        return null;
    }

    @Override
    public int updateByExampleSelective(User record, UserExample example) {
        return 0;
    }

    @Override
    public int updateByExample(User record, UserExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return 0;
    }
}
