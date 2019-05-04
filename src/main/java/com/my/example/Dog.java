package com.my.example;

/**
 * @Description: java类作用描述
 * @Author: luqihua
 * @CreateDate: 2019/5/3$ 22:26$
 */
public class Dog implements Ability {
    @Override
    public void eat() {
        System.out.println("--i am dog,i eat dog food---");
    }

    @Override
    public void run() {
        System.out.println("--i am dog, i can run---");
    }
}
