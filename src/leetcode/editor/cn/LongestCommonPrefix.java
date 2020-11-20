//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
// 示例 1:
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
//
//
// 示例 2:
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
//
//
// 说明:
//
// 所有输入只包含小写字母 a-z 。
// Related Topics 字符串
// 👍 1351 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        String[] strs = {"flower","flow","flight"};
        String[] strs2 = {"dog","racecar","car"};
        System.out.println(solution.longestCommonPrefix(strs));
        System.out.println(solution.longestCommonPrefix(strs2));


    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        int length = strs.length;
        //排序
        Arrays.sort(strs);
        //最短
        String min = strs[0];
        //最长
        String max = strs[length -1];
        char[] minChar = min.toCharArray();
        char[] maxChar = max.toCharArray();
        int i=0;
        //最短最为边界，对min和max比较
        while (i<=minChar.length-1 && minChar[i] == maxChar[i]) {
            i++;
        }
        return min.substring(0,i);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
