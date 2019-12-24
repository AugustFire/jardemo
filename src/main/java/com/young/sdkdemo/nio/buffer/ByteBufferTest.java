package com.young.sdkdemo.nio.buffer;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * create_time 2019/11/20
 *
 * @author yzx
 */
public class ByteBufferTest {

    @Test
    public void test01() throws IOException, InterruptedException {

//        SocketChannel sc = SocketChannel.open();
//        //no blocking
//        sc.configureBlocking(false);
//        sc.connect(new InetSocketAddress("localhost", 8080));

        String key = "Hello I am young \\r\\n";
        ByteBuffer byteBuffer = ByteBuffer.wrap(key.getBytes());

        ServerSocketChannel ssc = ServerSocketChannel.open();
        ServerSocket serverSocket = ssc.socket();

        serverSocket.bind(new InetSocketAddress(8080));

        ssc.configureBlocking(false);

        while (true) {
            System.out.println("wait for connect");
            SocketChannel sc = ssc.accept();
            if (sc == null) {
                Thread.sleep(2000);
            }else {
                sc.configureBlocking(false);
            }

        }
    }


    @Test
    public void test02() {
    }

}
