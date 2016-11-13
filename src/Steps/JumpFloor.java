package Steps;

/**
 * Created by duyan on 2016/10/29.
 */
public class JumpFloor {

    private static JumpFloor jumpFloor = new JumpFloor();

    public long jump(long target){
        if(target == 1)
            return 1;
        if(target == 2)
            return 2;

        long a = 2;
        long b = 1;
        long sum = 0;

        for(sum = 3;sum<=target;sum++){
            sum = a+b;
            b = a;
            a = sum;
        }

        return sum;

    }

    public static void main(String[] args){
        System.out.println(jumpFloor.jump(3));
    }
}
