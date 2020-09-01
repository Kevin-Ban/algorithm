package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

public class NIOTest {

    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("C:\\Users\\BDX\\Desktop\\1.txt");
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\BDX\\Desktop\\2.txt");
        Channel inputChannel = inputStream.getChannel();
        Channel outChannel = outputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        ((FileChannel) inputChannel).read(byteBuffer);
        byteBuffer.flip();
        int i = byteBuffer.limit();
        while (true) {
            i--;
            byte b = byteBuffer.get();
            System.out.print(b + " ");
            if (i == 0 || b == 'a') {
                byteBuffer.mark();
                break;
            }
        }
        ((FileChannel) outChannel).write(byteBuffer);
        byteBuffer.reset();
        ((FileChannel) outChannel).write(byteBuffer);
        inputChannel.close();
        outChannel.close();
        inputStream.close();
        outputStream.close();
    }
}
