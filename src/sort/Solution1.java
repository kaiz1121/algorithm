package sort;


import java.util.*;

public class Solution1 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.stream(nums1).forEach(num -> set.add(num));
        Arrays.stream(nums2).forEach(num -> set.add(num));
        int[] returnArray = new int[set.size()];
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            int i = 0;
            int index =(int) iterator.next();
            if (Arrays.asList(nums1).contains(index) && Arrays.asList(nums2).contains(index)){
                returnArray[i++] = index;
            }
        }
        return returnArray;
    }

    public static void main(String[] args) {
        int[] num1 = {1,2,2,1};
        int[] num2 = {2,2};
        int[] ints = intersection(num1,num2);
        System.out.println(Arrays.toString(ints));
    }
}
