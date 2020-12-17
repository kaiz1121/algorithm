//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
//
//
// 示例 1:
//
//
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
//
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
//
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
//
// 示例 4:
//
//
//输入: s = ""
//输出: 0
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 5 * 104
// s 由英文字母、数字、符号和空格组成
//
// Related Topics 哈希表 双指针 字符串 Sliding Window
// 👍 4721 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        String s4 = "";
        String s5="abba";
        System.out.println(solution.lengthOfLongestSubstring(s1));
        System.out.println(solution.lengthOfLongestSubstring(s2));
        System.out.println(solution.lengthOfLongestSubstring(s3));
        System.out.println(solution.lengthOfLongestSubstring(s4));
        System.out.println(solution.lengthOfLongestSubstring(s5));

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0,n=s.length(),result=0;
        //key是字符，value是当前字符所处的下标
        Map<Character,Integer> map = new HashMap<>();
        for (int i=0;i<n;i++){
            char c = s.charAt(i);
            if (map.containsKey(c)){
                //若map中存在当前key，则修改最长字符左边界:左边界取当前字符在map中已存在元素的下标位置+1
                left = Math.max(left,map.get(s.charAt(i))+1);
            }
            //更新map中当前元素的位置
            map.put(c,i);
            //每处理一次字符，则更新一次最长结果
            result = Math.max(result,i-left+1);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
