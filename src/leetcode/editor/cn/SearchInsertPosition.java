//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
// 你可以假设数组中无重复元素。
//
// 示例 1:
//
// 输入: [1,3,5,6], 5
//输出: 2
//
//
// 示例 2:
//
// 输入: [1,3,5,6], 2
//输出: 1
//
//
// 示例 3:
//
// 输入: [1,3,5,6], 7
//输出: 4
//
//
// 示例 4:
//
// 输入: [1,3,5,6], 0
//输出: 0
//
// Related Topics 数组 二分查找
// 👍 743 👎 0

package leetcode.editor.cn;

public class SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new SearchInsertPosition().new Solution();
        int[] nums = {1, 3, 5, 6};
        int[] nums2 = {1, 3};

        System.out.println(solution.searchInsert(nums, 5));
        System.out.println(solution.searchInsert(nums, 2));
        System.out.println(solution.searchInsert(nums, 7));
        System.out.println(solution.searchInsert(nums, 0));

        System.out.println(solution.searchInsert(nums2, 2));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            return searchValueIndex(nums, target, 0, nums.length - 1);
        }

        /**
         * 思路：很典型的二分查找，此处采用递归方式；
         * 从中间开始找，满足返回；
         * 若小于数组中间值则将中间值-1作为右边界进行递归
         * 若大于数组中间值则将中间值+1作为左边界进行递归
         *
         */
        private int searchValueIndex(int[] arrays, int value, int first, int last) {
            if (value < arrays[first]) return first;
            if (value > arrays[last]) return last + 1;
            if (first > last) return first;
            int center = first + (last - first)/2;
            if (arrays[center] > value) {
                return searchValueIndex(arrays, value, first, center - 1);
            } else if (arrays[center] < value) {
                return searchValueIndex(arrays, value, center + 1, last);
            } else {
                return center;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
