package com.young.sdkdemo.stringtest;

import org.apache.http.impl.conn.Wire;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author: yzx
 * @date: 2018/8/24
 * @description: 关于String常用方法的测试类
 */
public class StringDemoTest {

    @Test
    public void test0() throws IOException {
        String xx = "C:/Users/yzx/Desktop/123/AI教师";
        File file = new File(xx);
        System.out.println(file.exists());
        File file1 = new File(xx, "1.txt");
        File parentFile = file1.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (!file1.exists()) {
            boolean newFile = file1.createNewFile();
            System.out.println("create__"+newFile);
        }
        System.out.println(file.getPath());
        System.out.println(file1.getPath());
    }


    @Test
    public void test01() {
        writeFile(1);


    }

    @Test
    public void testV1() {
        System.out.println(123);
    }


    private static void writeFile(int N) {
        System.out.println("writeFile start >>>");
        RandomAccessFile file = null;
        try {
            System.out.println("Will write " + N + "GB data ...");
            final String FILE_NAME = N + "GB.bin";
            File f = new File("C:/Users/yzx/Desktop/xx", FILE_NAME);
            if (f.exists()) {
                f.delete();
            }
            file = new RandomAccessFile(FILE_NAME, "rw");
            //1G
            final int ONE_G_LENGTH = 1073741824;
            //1G
            byte[] b = new byte[ONE_G_LENGTH];
            b[0] = '0';
            b[b.length - 1] = '1';
            for (int i = 0; i < N; ++i) {
                file.write(b);
                file.seek(file.length());
                System.out.println("write " + (i + 1) + "GB data");
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (file != null) {
                try {
                    file.close();
                    file = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("writeFile end <<<");
    }

}
