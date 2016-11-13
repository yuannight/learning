package io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by duyan on 2016/10/30.
 */
public class RandomFile {

    private static RandomFile randomFile = new RandomFile();

    public void randomAccessFileTest(){
        try (RandomAccessFile raf = new RandomAccessFile("./src/info.text","r")) {
            System.out.println("指针位置"+raf.getFilePointer());
            raf.seek(10);
            byte[] buff= new byte[1024];
            int hasRead = 0;
            while ((hasRead = raf.read(buff))>0){
                System.out.println(new String(buff,0,hasRead));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readListLine(){
        String lastLine = null;
        try (RandomAccessFile raf = new RandomAccessFile("./src/info.text","r")) {

            long len = raf.length();
            if (len != 0L) {
                long pos = len - 1;
                while (pos > 0) {
                    pos--;
                    raf.seek(pos);
                    int c = raf.read();
                    if (c == '\n' || c == '\r') {
                        lastLine = raf.readLine();
                        if(lastLine != null && lastLine.length()>0){
                            break;
                        }
                    }
                }
                if(pos == 0){
                    raf.seek(pos);
                    lastLine = raf.readLine();
                }
                System.out.println(lastLine);
            }else{
                System.out.println("文件为空");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        randomFile.readListLine();
    }
}
