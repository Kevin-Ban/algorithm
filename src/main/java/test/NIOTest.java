package test;

import com.google.common.io.Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOTest {

    public static void main(String[] args) throws IOException {
//        copy("e:\\test\\main_2.mp4", "e:\\test\\testCopy.mp4");
        checkNIO();
    }

    public static void copy(String source, String dest) throws IOException {
        FileInputStream inputStream = new FileInputStream(source);
        FileOutputStream outputStream = new FileOutputStream(dest);
        FileChannel inputChannel = inputStream.getChannel();
        FileChannel outChannel = outputStream.getChannel();
        ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
        try {
            while (true) {
                writeBuffer.clear();
                int len = inputChannel.read(writeBuffer);
                if (len == -1) {
                    break;
                }
                writeBuffer.flip();
                outChannel.write(writeBuffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            inputChannel.close();
            outChannel.close();
        }
    }

    public static void checkNIO() {
        ByteBuffer b = ByteBuffer.allocate(15);
        System.out.println("limit = " + b.limit() + "; capacity = " + b.capacity() + "; position=" + b.position());
        for (int i = 0; i < 10; i++) {
            b.put((byte) i);
        }
        System.out.println("limit = " + b.limit() + "; capacity = " + b.capacity() + "; position=" + b.position());
        for(int i = 0; i < 5; i++){
            System.out.println(b.get());
        }
        System.out.println();
        System.out.println("limit = " + b.limit() + "; capacity = " + b.capacity() + "; position=" + b.position());
        b.flip();
        System.out.println("limit = " + b.limit() + "; capacity = " + b.capacity() + "; position=" + b.position());
    }
}
