package nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * Created by duyan on 2016/10/30.
 */
public class NioTest {

    private static NioTest nioTest= new NioTest();

    /**
     * fileChannelTest 文件内容复制
     */
    public void fileChannelTest(){
        File file = new File("./src/info.text");
        try (
                FileChannel inChannel = new FileInputStream(file).getChannel();
                FileChannel outChannel = new FileOutputStream("./src/info1.text").getChannel();
        ) {
            //这种是直接把channel中的所有东西，都扔buffer里边
            ByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY,0,file.length());
            outChannel.write(buffer);
            buffer.clear();

            //解码器
            Charset charset = Charset.forName("UTF-8");
            CharsetDecoder decoder = charset.newDecoder();
            CharBuffer charBuffer = decoder.decode(buffer);
            System.out.println(charBuffer);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 把一个文件的内容复制到另一个文件的最后
     */
    public void contextAdd(){
        File file = new File("./src/info.text");
        File file1 = new File("./src/info1.text");
        try (
                FileChannel inChannel = new RandomAccessFile(file,"rw").getChannel();
                FileChannel outChannel = new RandomAccessFile(file1,"rw").getChannel();
        ) {
            //map需要指定长度，file能获取length，RandomAccessFile也可以
            //这种是直接把channel中的所有东西，都扔buffer里边
            ByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY,0,file.length());
            outChannel.position(file1.length());
            outChannel.write(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 一次少取，多取几次
     */
    public void setBuferSizeTest(){

        try (
                RandomAccessFile raf = new RandomAccessFile("./src/info.text", "rw");
                FileChannel fc = raf.getChannel();

        ) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (fc.read(buffer)!=-1){
                buffer.flip();

                Charset charset = Charset.forName("UTF-8");
                CharsetDecoder decoder = charset.newDecoder();
                CharBuffer charBuffer = decoder.decode(buffer);
                System.out.println(charBuffer);
                buffer.clear();

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        nioTest.setBuferSizeTest();
    }
}
