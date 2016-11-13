package threadPool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * Created by duyan on 2016/10/31.
 */
public class ForkJoinPoolTest extends RecursiveAction{

    private static final int THRESHOLE = 50;

    private int start,end;

    public ForkJoinPoolTest(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if(end-start<THRESHOLE){
            for(int i= start;i<end;i++){
                System.out.println(Thread.currentThread().getName()+"i的值为"+i);
            }
        }else{
            int middle = (start+end)/2;
            ForkJoinPoolTest left = new ForkJoinPoolTest(start,middle);
            ForkJoinPoolTest right = new ForkJoinPoolTest(middle,end);
            //异步执行任务
            left.fork();
            right.fork();
        }
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        pool.submit(new ForkJoinPoolTest(0,300));
        try {
            pool.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pool.shutdown();
    }
}
