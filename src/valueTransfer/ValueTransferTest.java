package valueTransfer;

/**
 * Created by duyan on 2016/10/31.
 */
public class ValueTransferTest {

    public void change(int[] arr){
        arr[0]=123;
        arr[1]=456;
    }

    public static void main(String[] args) {
        int[] arr = {1,2};
        ValueTransferTest transferTest = new ValueTransferTest();
        transferTest.change(arr);
        System.out.println(arr[0]+" "+ arr[1]);
    }
}
