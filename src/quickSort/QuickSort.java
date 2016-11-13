package quickSort;

import com.sun.deploy.util.ArrayUtil;
import com.sun.xml.internal.bind.v2.model.annotation.Quick;

/**
 * Created by duyan on 2016/10/29.
 */
public class QuickSort {


    public void quickSort(int[] arr,int l,int r){
        if(l<r){
            int left = l,right = r,temp = arr[l];

            while(left<right){
                while(left<right && arr[right]>=temp){
                    right--;
                }

                if(left<right){
                    arr[left++] = arr[right];
                }

                while(left<right && arr[left]<temp){
                    left++;
                }

                if(left<right){
                    arr[right--] = arr[left];
                }
            }

            arr[left] = temp;//别忘记了，要不换没了
            quickSort(arr,l,left-1);
            quickSort(arr,right+1,r);
        }
    }

    public static void main(String[] args){
        int[] arr = {5,4,2,6,1,7,8,9,2,0};
        QuickSort qs = new QuickSort();
        qs.quickSort(arr,0,arr.length-1);
        for(int i: arr){
            System.out.print(i);
        }
    }
}
