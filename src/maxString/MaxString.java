package maxString;

/**
 * Created by duyan on 2016/10/31.
 */
public class MaxString {

    public void getMaxString(){
        int[] array = {-1,15,10,-5,3,6,9,-8};
        int max = array[0];
        int currentMax = array[0];

        for (int i = 1; i < array.length; i++)
        {
            currentMax = Math.max(array[i], array[i] + currentMax);
            max = Math.max(max, currentMax);
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        MaxString maxString = new MaxString();
        maxString.getMaxString();
    }
}
