package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOTest {

    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("C:\\Users\\BDX\\Desktop\\1.txt");
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\BDX\\Desktop\\2.txt");
        FileChannel inputChannel = inputStream.getChannel();
        FileChannel outChannel = outputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        inputChannel.read(byteBuffer);
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
        outChannel.write(byteBuffer);
        byteBuffer.reset();
        outChannel.write(byteBuffer);
        inputChannel.close();
        outChannel.close();
        inputStream.close();
        outputStream.close();
    }
}
