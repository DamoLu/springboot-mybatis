package com.my;

import com.my.example.Ability;
import com.my.example.Cat;
import com.my.mapper.UserMapper;
import com.my.model.User;
import com.my.proxy.CglibProxyFactory;
import com.my.proxy.JdkProxyFactory;
import com.my.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisApplicationTests {

    @Test
    public void contextLoads() throws SQLException {

    }

    @Test
    public void testJdkProxy() {
        Ability target = new Cat();
        Ability proxy = (Ability) new JdkProxyFactory(target).getProxyInstance();
        proxy.eat();
    }

    @Test
    public void testCglibProxy() {
        Cat target = new Cat();
        Cat proxy = (Cat) new CglibProxyFactory(target).getCglibProxyFactoryInstance();
        proxy.eat();
    }

}
