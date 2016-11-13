package inputStr;

import java.util.Scanner;

/**
 * Created by duyan on 2016/10/29.
 */
public class InputString {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String temp = null;
        while(scanner.hasNext()){
            System.out.println("请输入下一个");
            temp = scanner.next();
            System.out.println("您输入的是"+temp);
        }


    }
}
