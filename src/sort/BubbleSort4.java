package sort;

import java.util.Arrays;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 *
 * @author kaiz
 * @date 22:20 2019-06-12.
 */
public class BubbleSort4 {
    public static void sort(int array[]){
        int tmp = 0;
        for (int i = 0; i<array.length/2; i++){
            //有序标记，每一轮初始值为true ,默认有序
            boolean isSorted = true;

            //奇数轮排序，从左往右比较和交换
            for (int j=i; j<array.length-i-1; j++){
                if (array[j] > array[j+1]){
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    //执行上面的逻辑代表还有元素进行交换了，所以不是有序的，有序标记设置为false
                    isSorted = false;
                }
            }
            //在外层循环内判断有序标记，有序true直接结束循环，无序false则继续下一轮
            if (isSorted){
                break;
            }

            //在偶数轮排序前，先将isSorted重新标记为true
            isSorted = true;
            //偶数轮排序，从右往左比较和交换
            for(int j=array.length-i-1; j>i; j--){
                if (array[j] < array[j-1]){
                    tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                    //执行上面的逻辑代表还有元素进行交换了，所以不是有序的，有序标记设置为false
                    isSorted = false;
                }
            }
            //在外层循环内判断有序标记，有序true直接结束循环，无序false则继续下一轮
            if (isSorted){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{2,3,4,5,6,7,8,1};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
