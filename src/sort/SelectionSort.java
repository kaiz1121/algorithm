package sort;

import java.util.Arrays;

/**
 * 选择排序
 * 对于给定的一组记录，经过第一轮比较后得到最小的记录，
 * 然后将该记录的位置与第一个记录的位置交换；
 * 接着对不包括第一个记录以外的其他记录进行第二次比较，得到最小记录并与第二个位置记录交换；
 * 重复该过程，知道进行比较的记录只剩下一个为止
 *
 * 时间复杂度 O(n*n)
 */
public class SelectionSort {
    public static void selectSort(int []a){
        if (a==null || a.length<=0){
            return ;
        }

        for (int i=0;i<a.length;i++){//做第i次排序
            int flag=i;//将当前小标定义为最小数据
            for(int j =flag+1;j<a.length;j++){
                if (a[j]<a[flag]){
                    flag=j;//记下目前找到的最小值的下标
                }
            }
            //在内层循环结束周，也就是找到本轮循环的最小的数后a[flag]，进行交换
            if (i!=flag){
                //交换a[i]和本轮找到的最小值a[flag]的位置
                int tmp=a[i];
                a[i]=a[flag];
                a[flag]=tmp;
            }
        }
    }

    public static void main(String[] args){
        int[] a= {23,22,44,66,54,1,8};
        selectSort(a);
        System.out.println(Arrays.toString(a));
    }
}
