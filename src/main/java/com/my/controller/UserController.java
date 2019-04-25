package com.my.controller;

import com.github.pagehelper.PageHelper;
import com.my.exception.BusinessException;
import com.my.mapper.UserMapper;
import com.my.model.User;
import com.my.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController extends Throwable{

    @Autowired
    UserMapper userMapper;

    @Value("${msg}")
    private String msg;

    @GetMapping("/hi")
    public String hello() {
        return msg;
    }

    @GetMapping("insert/{id}/{userName}")
    public void add(@PathVariable("id") Integer id, @PathVariable("userName") String userName) {
        User user = new User();
        user.setUserName(userName);
        user.setUserId(id);
        user.setPhone("13546897545");
        user.setPassword("123456");
        userMapper.insert(user);
    }

    @GetMapping("find")
    @ResponseBody
    public User findById(@RequestParam("id") Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        if (null == user) {
           throw new BusinessException("404", "没有此用户");
        }
        return user;
    }


    @RequestMapping(value = "/all/{pageNum}/{pageSize}")
    public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserIdBetween(1, 3);
        List<User> users = userMapper.selectByExample(userExample);
        return users;
    }
}
