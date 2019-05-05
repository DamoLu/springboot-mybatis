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

    public void testWriter() throws IOException {
        File file = new File("E:" + File.separator + "output"
                + File.separator + "writer" + File.separator + "hi.txt");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        String str = "我就是想告诉别人，我失去的东西，我一定能够要得回来";
        Writer writer = new FileWriter(file);
        writer.write(str);
        //字符流使用了缓存，若不关闭，内容不会输出到文件
        writer.close();
        //清空后可以输出
        //writer.flush();
    }

    public void testReader() throws IOException {
        File file = new File("E:" + File.separator + "output"
                + File.separator + "writer" + File.separator + "hello.txt");
        if (file.exists()) {
            Reader reader = new FileReader(file);
            char[] data = new char[1024];
            int len = reader.read(data);
            reader.close();
            System.out.println(new String(data));
        }
    }

    public void testCopy() throws Exception{
        File inFile = new File("E:" + File.separator + "output"
                + File.separator + "demo" + File.separator + "hello.jpg");
        File outFile = new File("E:" + File.separator + "output"
                + File.separator + "writer" + File.separator + "hello.jpg");

        if (!outFile.getParentFile().exists()) {
            outFile.getParentFile().mkdirs();
        }

        if (inFile.exists()) {
            InputStream inputStream = new FileInputStream(inFile);
            OutputStream outputStream = new FileOutputStream(outFile);

            int temp = 0; //保存每次读取的个数
            byte[] data = new byte[1024];
            while ((temp = inputStream.read(data)) != -1) {
                outputStream.write(data, 0, temp);
            }
            inputStream.close();
            outputStream.close();
        }
    }
}
