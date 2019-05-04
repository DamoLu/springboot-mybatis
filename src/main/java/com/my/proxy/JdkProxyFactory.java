package com.my.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description: java类作用描述
 * @Author: luqihua
 * @CreateDate: 2019/5/3$ 21:46$
 *
 * 动态代理
 */
public class JdkProxyFactory {

    private Object target;

    public JdkProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
       return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("--开启事务---");
                        //执行目标方法
                        Object returnValue = method.invoke(target, args);
                        System.out.println("--事务结束--");
                        return returnValue;
                    }
                });
    }
}
