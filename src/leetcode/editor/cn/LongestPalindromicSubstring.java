//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
// 示例 1：
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
//
//
// 示例 2：
//
// 输入: "cbbd"
//输出: "bb"
//
// Related Topics 字符串 动态规划
// 👍 3011 👎 0

package leetcode.editor.cn;
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("babad"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || "".equals(s)) return "";
        String reverseS = new StringBuilder(s).reverse().toString();
        String r = "";
        for (int i=0;i<s.length();i++) {
            StringBuilder result = new StringBuilder();
            if (s.charAt(i) == reverseS.charAt(i)) {
                result.append(s.charAt(i));
            }else {
                continue;
            }
            if (r.length() < result.length())
                r = result.toString();
        }
        /**
         * babad
         * dabab
         *
         *
         */

        return r;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
