package javaNio;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by duyan on 2016/9/2.
 */
public class MyClient {

    public static void main(String[] args) {
        File file = new File("F:\\1234.JPG");
        try (
                Socket socket = new Socket("127.0.0.1", 4700);
             //由系统标准输入设备构造BufferedReader对象
             BufferedOutputStream os = new BufferedOutputStream(socket.getOutputStream());
             //由Socket对象得到输入流，并构造相应的BufferedReader对象
            FileInputStream fis = new FileInputStream(file);
        ) {
            int c;
            byte[] buf = new byte[1024];
            while((c=fis.read(buf)) !=-1){
                os.write(buf,0,c);
            }
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
       /* try {
            FileInputStream fis = new FileInputStream(file);
            byte[] buff = new byte[1024];
            int hasRead = 0;
            while ((hasRead = fis.read(buff)) > 0){
                System.out.println(hasRead);
               // System.out.println(new String(buff,0,hasRead));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }
}
