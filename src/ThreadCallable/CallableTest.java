package ThreadCallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by duyan on 2016/9/1.
 */
public class CallableTest {

    public static void main(String[] args){
        CallableTest callableTest = new CallableTest();
        List<String> s = new ArrayList<>();

        //创建callable对象
        FutureTask<Integer> task = new FutureTask<Integer>((Callable<Integer>)() ->{
            int i = 0;
            for(;i<100;i++){
                System.out.println(Thread.currentThread().getName()
                +"i的值："+ i );
            }
            return i;
        });
        for(int i = 0 ; i < 100 ;i++){
            System.out.println(Thread.currentThread().getName()
            +"i的值" + i);
            if(i == 20){
                new Thread(task,"有返回值的线程").start();
            }
        }

        try {
            System.out.println("子线程返回值："+ task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
