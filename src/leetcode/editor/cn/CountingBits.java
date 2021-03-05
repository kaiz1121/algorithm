//给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
//
// 示例 1:
//
// 输入: 2
/*
  0: 0
  1:1
  2:10
 */

//输出: [0,1,1]
//
// 示例 2:
//
// 输入: 5
/*
 0:0
 1:1
 2:10
 3:11
 4:100
 5：101
 6: 110
 7: 111
 8: 1000
 奇数： a[i-1] + 1
 偶数: a[i/2]
 */
//输出: [0,1,1,2,1,2]
//
// 进阶:
// 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
// 要求算法的空间复杂度为O(n)。
// 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
//
// Related Topics 位运算 动态规划
// 👍 576 👎 0

package leetcode.editor.cn;
public class CountingBits {
    public static void main(String[] args) {
        Solution solution = new CountingBits().new Solution();
        int[] result = solution.countBits(5);
        for (int i =0;i<result.length;i++) {
            System.out.println(result[i]);
        }

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        result[0] = 0;
        for (int i=1;i <= num; i++) {
            if ((i&1) == 0) {
                //偶数
                result[i] = result[i>>1];
            }else {
                //奇数
                result[i] = result[i-1] + 1;
            }
        }
        return result;
    }




}
//leetcode submit region end(Prohibit modification and deletion)

}
