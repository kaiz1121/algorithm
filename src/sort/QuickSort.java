package sort;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] array){
        if (array.length > 0){
            quickSort(array,0,array.length-1);
        }
    }

    public static void quickSort(int[] arr,int start,int end) {
        if(start >= end) {
            return;
        }
        int i,j,index;
        i = start;
        j = end;
        index = arr[i];

        while(i < j) {
            while (i < j && arr[j] >= index) {
                j--;
            }
            while (i < j && arr[i] < index) {
                i++;
            }
            if(i < j) {
                int empt = arr[i];
                arr[i] = arr[j];
                arr[j] = empt;
            }
        }
        if(arr[i] < arr[start]) {
            int empt = arr[i];
            arr[i] = arr[start];
            arr[start] = empt;
        }

        quickSort(arr, start, i - 1);
        quickSort(arr, i + 1, end);

    }


    public static void main(String[] args) {
        int[] array = new int[]{3,1,9,4,54,45,45,8,90,91};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
