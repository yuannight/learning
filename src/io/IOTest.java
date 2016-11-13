package io;

import java.io.*;
import java.nio.channels.Pipe;

/**
 * Created by duyan on 2016/10/30.
 * Java io 联系相关
 */
public class IOTest {

    private static IOTest ioTest = new IOTest();

    /**
     * fileInputStream测试
     */
    public void fileInputStreamTest(){
        try (
                FileInputStream fis = new FileInputStream("./src/io/IOTest.java");

        ) {
            byte[] buff = new byte[10];
            int hasRead = 0;
            while ((hasRead = fis.read(buff))>0){
                System.out.print(new String(buff,0,hasRead));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /**
     * fileOuputStreamTest
     */
    public void fileOuputStreamTest(){
        try (
                FileInputStream fis = new FileInputStream("./src/io/IOTest.java");
                FileOutputStream fos = new FileOutputStream("./src/info.text");
        ) {
            byte[] buff = new byte[2];
            int hasRead = 0;
            while ((hasRead = fis.read(buff))>0){
                fos.write(buff,0,hasRead);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * fileReader测试
     */
    public void fileReader(){
        try (FileReader fr = new FileReader("./src/io/IOTest.java")) {
            char[] buff = new char[20];
            int hasRead = 0;
            while ((hasRead=fr.read(buff))>0){
                System.out.print(new String(buff,0,hasRead));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * fileWriter
     */
    public void fileWriter(){
        try (
                FileWriter fw = new FileWriter("./src/info.text");
        ) {
           fw.write("askdfjsldfjl \r\n");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * printStreamTest处理流
     */
    public void printStreamTest(){
        try (
            FileOutputStream fos = new FileOutputStream("./src/info.text");
            PrintStream ps = new PrintStream(fos);
        ) {
            ps.println("普通字符串");
            ps.println(ioTest);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void bufferReaderTest(){
        try (
                InputStreamReader is = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(is);
        ) {
            String line = null;
            while ((line = br.readLine())!=null){
                if(line.equals("exit")){
                    System.exit(1);
                }

                System.out.println("输入的内容为"+line);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ioTest.bufferReaderTest();
    }

}
