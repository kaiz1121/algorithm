package sort;

import java.util.Arrays;

public class BubbleSort {

    private static void sort(int arrary[]){
        for (int i = 0; i<arrary.length - 1;i++){
            //有序标记，每一轮初始值为true ,默认有序
            boolean isSorted = true;
            //无序数列的边界，每次比较到这就结束
            int sortBorder = arrary.length - 1;
            for (int j = 0; j<sortBorder; j++){
                int tmp = 0;
                if (arrary[j] > arrary[j+1]){
                    tmp = arrary[j];
                    arrary[j] = arrary[j+1];
                    arrary[j+1] = tmp;
                    //执行上面的逻辑代表还有元素进行交换了，所以不是有序的，有序标记设置为false
                    isSorted = false;
                    //将当前无序数列的边界更新为最后一次交换元素的位置
                    sortBorder = j;
                }
            }
            //在外层循环内判断有序标记，有序true直接结束循环，无序false则继续下一轮
            if (isSorted){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{3,4,2,1,5,6,7,8};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}