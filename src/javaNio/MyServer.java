package javaNio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by duyan on 2016/9/2.
 */
public class MyServer {
    public static void main(String args[]) {
        try (
                ServerSocket server = new ServerSocket(4700);
                Socket socket = server.accept();
                FileInputStream is = (FileInputStream)socket.getInputStream();
        ) {
            FileOutputStream fis = new FileOutputStream(new File("F:/555.jpg"));
            while (true){
                fis.write(is.read());
                fis.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
