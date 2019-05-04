package com.my.example;

/**
 * @Description: java类作用描述
 * @Author: luqihua
 * @CreateDate: 2019/5/3$ 22:27$
 */
public class Cat implements Ability {
    @Override
    public void eat() {
        System.out.println("---i am Cat,i eat Cat food----");
    }

    @Override
    public void run() {
        System.out.println("---i am Cat, i can run----");
    }
}
