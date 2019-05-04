package com.my.iotest;

import java.io.*;

/**
 * @Description: java类作用描述
 * @Author: luqihua
 * @CreateDate: 2019/5/4$ 21:26$
 */
public class IoTest {

    //如果嵌套了多层目录，创建文件时需先判断父文件目录是否存在
    public void testFile() throws IOException {
        File file = new File("E:" + File.separator + "hello"
                + File.separator + "demo" + File.separator + "hello.txt");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
    }

    public void testOutPutStream() throws IOException {
        File file = new File("E:" + File.separator + "output"
                + File.separator + "demo" + File.separator + "hello.txt");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
        //追加输出，append = true
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        String str = "好好学习，天天向上\r\n";
        fileOutputStream.write(str.getBytes());
        fileOutputStream.close();
    }

    public void testInputStream() throws IOException {
        File file = new File("E:" + File.separator + "output"
                + File.separator + "demo" + File.separator + "hello.txt");
        if (file.exists()) {
            FileInputStream inputStream = new FileInputStream(file);
            byte[] data = new byte[1024];
            //1.读取数组的方式
            //int len = inputStream.read(data);
            //2.读取单个字节的方式
            int index = 0;
            int temp = 0; //表示读取的字节数据
            while ((temp = inputStream.read()) != -1) {
                data[index ++] = (byte)temp ;
            }
            inputStream.close();
            System.out.println("[" + new String(data, 0, index) + "]");
        }
    }
}
