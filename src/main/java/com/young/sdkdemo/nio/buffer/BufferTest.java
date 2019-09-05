package com.young.sdkdemo.nio.buffer;

import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * buffer demo
 *
 * @author yzx
 * @date 2019-9-4
 */

public class BufferTest {

    @Test
    public void byteBufferTest() throws IOException {
        //打开server socket channel 并且绑定端口号
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.socket().bind(new InetSocketAddress(InetAddress.getByName("ip"), 8099));
        ssc.configureBlocking(false);
        //创建Reactor线程
        Selector selector = Selector.open();
//        new Thread(new ReactorTask())


    }
}
