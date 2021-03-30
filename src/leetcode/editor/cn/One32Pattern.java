//给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < a
//j。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
//
// 注意：n 的值小于15000。
//
// 示例1:
//
//
//输入: [1, 2, 3, 4]
//
//输出: False
//
//解释: 序列中不存在132模式的子序列。
//
//
// 示例 2:
//
//
//输入: [3, 1, 4, 2]
//
//输出: True
//
//解释: 序列中有 1 个132模式的子序列： [1, 4, 2].
//
//
// 示例 3:
//
//
//输入: [-1, 3, 2, 0]
//
//输出: True
//
//解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0].
//
// Related Topics 栈
// 👍 321 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Stack;

public class One32Pattern {
    public static void main(String[] args) {
        Solution solution = new One32Pattern().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //i < j < k 时，ai < ak < aj
    public boolean find132pattern(int[] nums) {
        int length = nums.length;
        if (nums.length < 3) return false;
        int[] ai = new int[length];
        ai[0] = nums[0];
        //把nums和前一个最小元素比较,放置到ai中
        for (int i=1; i<length; i++) {
            ai[i] = Math.min(ai[i-1], nums[i]);
        }
        Stack<Integer> stack = new Stack<>();
        int j = length-1;
        while (j >=0) {
            if (nums[j] > ai[j]) {
                //ak和ai比，若ak是小于等于ai，则不满足丢出stack,过滤出所有满足ak > ai的元素
                while (!stack.isEmpty() && stack.peek() <= ai[j]) {
                    stack.pop();
                }
                //ak和aj比,若ak<aj，那么现在既满足ak<aj，又满足ak>ai ，既满足 ai< ak < aj
                while (!stack.isEmpty() && stack.peek() < nums[j]) {
                    return true;
                }
                stack.push(nums[j]);
            }
            j--;
        }


//        for (int j=length-1; j>=0; j--) {
//            if (nums[j] > ai[j]) {
//                //ak和ai比，若ak是小于等于ai，则不满足丢出stack,过滤出所有满足ak > ai的元素
//                while (!stack.isEmpty() && stack.peek() <= ai[j]) {
//                    stack.pop();
//                }
//                //ak和aj比,若ak<aj，那么现在既满足ak<aj，又满足ak>ai ，既满足 ai< ak < aj
//                while (!stack.isEmpty() && stack.peek() < nums[j]) {
//                    return true;
//                }
//                stack.push(nums[j]);
//            }
//        }
        return false;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
