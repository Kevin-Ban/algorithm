package test;

import java.io.IOException;

public class NIOTest {

    public static void main(String[] args) throws IOException {

        // region test
//        FileInputStream inputStream = new FileInputStream("C:\\Users\\BDX\\Desktop\\1.txt");
//        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\BDX\\Desktop\\2.txt");
//        FileChannel inputChannel = inputStream.getChannel();
//        FileChannel outChannel = outputStream.getChannel();
//        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
//        inputChannel.read(byteBuffer);
//        byteBuffer.flip();
//        int i = byteBuffer.limit();
//        while (true) {
//            i--;
//            byte b = byteBuffer.get();
//            System.out.print(b + " ");
//            if (i == 0 || b == 'a') {
//                byteBuffer.mark();
//                break;
//            }
//        }
//        outChannel.write(byteBuffer);
//        byteBuffer.reset();
//        outChannel.write(byteBuffer);
//        inputChannel.close();
//        outChannel.close();
//        inputStream.close();
//        outputStream.close();
        // endregion

        //region NIO ByteBuffer
//        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\BDX\\Desktop\\1.txt");
//        FileChannel fileChannel = fileOutputStream.getChannel();
//        ByteBuffer byteBuffer = ByteBuffer.allocate(10240);
//        Random random = new Random();
//        for(int i = 0; i < 10000; i++) {
//            byteBuffer.clear();
//            for(int j = 0; j < 100; j++) {
//                byteBuffer.put(String.valueOf(random.nextInt()).getBytes());
//                byteBuffer.putChar('\n');
//            }
//            byteBuffer.flip();
//            fileChannel.write(byteBuffer);
//        }
//        fileChannel.close();
//        fileOutputStream.close();
        //endregion

        //region writer
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\BDX\\Desktop\\1.txt"), 1024);
//        Random random = new Random();
//        for (int i = 0; i < 10000; i++) {
//            int data = Math.abs(random.nextInt());
//            bufferedWriter.write(String.valueOf(data));
//            bufferedWriter.newLine();
//        }
//        bufferedWriter.flush();
//        bufferedWriter.close();
        //endregion

        //region reader
//        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\BDX\\Desktop\\1.txt"), 1);
//        String s = "";
//
//        List<Integer> list = new ArrayList<>(1024);
//        while((s = reader.readLine()) != null) {
//            list.add(Integer.parseInt(s));
//            System.out.println(s);
//        }
        //endregion
    }
}
