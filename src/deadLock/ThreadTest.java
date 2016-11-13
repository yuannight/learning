package deadLock;

/**
 * Created by duyan on 2016/6/30.
 */
public class ThreadTest {

    private static Resource r1 = new Resource("r1");

    private static Resource r2 = new Resource("r2");

    public static void main(String[] args){
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (r1){
                    System.out.println("thread1获取到r1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (r2){
                        System.out.println("thread1获取到r2");
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (r2){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread2获取到r2");
                    synchronized (r1){
                        System.out.println("thread2获取到r1");
                    }
                }
            }
        });

        //不能用run方法
        thread1.start();
        thread2.start();

    }
}
