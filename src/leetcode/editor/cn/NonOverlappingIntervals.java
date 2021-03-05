//给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
//
// 注意:
//
//
// 可以认为区间的终点总是大于它的起点。
// 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
//
//
// 示例 1:
//
//
//输入: [ [1,2], [2,3], [3,4], [1,3] ]
//
//输出: 1
//
//解释: 移除 [1,3] 后，剩下的区间没有重叠。
//
//
// 示例 2:
//
//
//输入: [ [1,2], [1,2], [1,2] ]
//
//输出: 2
//
//解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
//
//
// 示例 3:
//
//
//输入: [ [1,2], [2,3] ]
//
//输出: 0
//
//解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
//
// Related Topics 贪心算法
// 👍 308 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        Solution solution = new NonOverlappingIntervals().new Solution();
        int[][] ints = { {1,2},{2,3},{3,4},{1,3} };
        int[][] ints1 = {{1,2}, {1,2}, {1,2} };
        int[][] ints2 = {{1,2},{2,3}};
        int[][] ints3 = {{1,100},{11,22},{1,11},{2,12}};
        System.out.println(solution.eraseOverlapIntervals(ints));
        System.out.println(solution.eraseOverlapIntervals(ints1));
        System.out.println(solution.eraseOverlapIntervals(ints2));
        //[[1,100],[11,22],[1,11],[2,12]]
        System.out.println(solution.eraseOverlapIntervals(ints3));



    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <=1) return 0;
        //排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        //区间最大值
        int max = intervals[0][1];
        //后面区间的最小值是否小于当前区间的最大值，小于的话则去除大区间，否则取当前区间并移除计数+1
        int result = 0,i = 1;
        while (i < intervals.length) {
            if (intervals[i][0] >= max) {
                max = intervals[i][1];
            }else {
                max = Math.min(max, intervals[i][1]);
                result++;
            }
            i++;
        }
        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
