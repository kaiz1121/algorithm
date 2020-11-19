//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//
// 示例 1:
//
// 输入: 121
//输出: true
//
//
// 示例 2:
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
//
//
// 示例 3:
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
//
//
// 进阶:
//
// 你能不将整数转为字符串来解决这个问题吗？
// Related Topics 数学
// 👍 1311 👎 0

package leetcode.editor.cn;

public class PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new PalindromeNumber().new Solution();
        System.out.println(solution.isPalindrome(121));
        System.out.println(solution.isPalindrome(-121));
        System.out.println(solution.isPalindrome(10));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0)
                return false;
            int nums = 0;
            int temp = x;
            int left, right;
            while (temp != 0) {
                temp /= 10;
                nums++;
            }
            left = nums - 1;
            right = 0;
            while (left > right) {
                if (getDigit(x, left--) != getDigit(x, right++))
                    return false;
            }
            return true;
        }

        private int getDigit(int x, int i) {
            x = x / (int) Math.pow(10, i);
            return x % 10;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
