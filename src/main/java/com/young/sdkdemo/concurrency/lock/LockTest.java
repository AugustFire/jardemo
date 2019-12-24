package com.young.sdkdemo.concurrency.lock;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;


/**
 * create_time 2019/12/15
 *
 * @author yzx
 */
public class LockTest {


    @Test
    public void lockTest() {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
    }

    @Test
    public void lockSupportTest() throws IOException {
        File file = new File("C:\\Users\\yzx\\Desktop\\test\\1单元.zip");
        ZipFile zipFile = new ZipFile(file, Charset.forName("GBK"));
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = entries.nextElement();
            System.out.println(zipEntry.getName());
        }
    }

    /**
     * 阻塞队列
     */
    @Test
    public void lockCAS() {
        ArrayBlockingQueue bq = new ArrayBlockingQueue<>(10, false);
    }

    /**
     *
     */
    @Test
    public void lockFork() {
//        RecursiveTask;
    }
}
