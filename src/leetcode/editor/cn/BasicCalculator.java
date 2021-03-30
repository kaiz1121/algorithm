//实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。
//
//
//
// 示例 1：
//
//
//输入：s = "1 + 1"
//输出：2
//
//
// 示例 2：
//
//
//输入：s = " 2-1 + 2 "
//输出：3
//
//
// 示例 3：
//
//
//输入：s = "(1+(4+5+2)-3)+(6+8)"
//输出：23
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 3 * 105
// s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
// s 表示一个有效的表达式
//
// Related Topics 栈 数学
// 👍 421 👎 0

package leetcode.editor.cn;

import java.util.Stack;

public class BasicCalculator {
    public static void main(String[] args) {
        Solution solution = new BasicCalculator().new Solution();
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(solution.calculate(s));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
        Stack<Character> stack = new Stack();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c != ' ')
                stack.push(c);
        }
        int count = 0;
        while (!stack.isEmpty()) {
            char c = stack.pop();
            if (c == '(') {
                continue;
            }else if (c == ')') {

            }else {

            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
