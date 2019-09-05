package com.young.sdkdemo.nio.buffer;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Set;

/**
 * @author yzx
 * @date 2019-9-5
 */

public class MultiplexerTimerServer implements Runnable {

    private Selector selector;

    private ServerSocketChannel ssc;

    private volatile boolean stop;


    public MultiplexerTimerServer(int port) {
        try {
            selector = Selector.open();
            ssc = ServerSocketChannel.open();
            ssc.configureBlocking(false);
            ssc.socket().bind(new InetSocketAddress(port), 1024);
            ssc.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("The time server is start in port: " + port);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }


    public void stop() {
        this.stop = stop;
    }

    @Override
    public void run() {
        while (!stop) {
            try {
                selector.select(1000);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> it = selectionKeys.iterator();
                SelectionKey key = null;
                while (it.hasNext()) {
                    key = it.next();
                    it.remove();
                    try {
                        handleInput(key);
                    } catch (IOException e) {

                        key.cancel();
                        if (key.channel() != null) {
                            key.channel().close();
                        }
                        e.printStackTrace();


                    }

                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void handleInput(SelectionKey key) throws IOException {
        if (key.isValid()) {
            if (key.isAcceptable()) {
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                ssc.accept();
                ssc.configureBlocking(false);
                ssc.register(selector, SelectionKey.OP_READ);
            }
            if (key.isReadable()) {
                SocketChannel sc = (SocketChannel) key.channel();
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                int readByte = sc.read(readBuffer);
                if (readByte > 0) {
                    readBuffer.flip();
                    byte[] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    String body = new String(bytes, "UTF-8");
                    System.out.println("The time Server receive:______" + body);
                    String currentTime = "QUERY TIME".equals(body) ? LocalDateTime.now().toString() : "BAD ORDER";
                    dowrite(sc, currentTime);
                } else if (readByte < 0) {
                    key.cancel();
                    sc.close();
                } else {
                    System.out.println("0 byte read");
                }



            }


        }
    }

    private void dowrite(SocketChannel channel, String resp) throws IOException {
        if (resp != null) {
            byte[] bytes = resp.getBytes();
            ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
            byteBuffer.put(bytes);
            byteBuffer.flip();
            channel.write(byteBuffer);
        }
    }
}
