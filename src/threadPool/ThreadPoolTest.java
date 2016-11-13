package threadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by duyan on 2016/10/31.
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(10);

        Runnable target = ()->{
            for(int i=0;i<100;i++){
                System.out.println(Thread.currentThread().getName()+"的i为"+i);
            }
        };

        pool.submit(target);
        pool.submit(target);
        pool.shutdown();
    }

}
