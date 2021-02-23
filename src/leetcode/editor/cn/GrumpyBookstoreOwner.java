//今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分
//钟结束后离开。
//
// 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一
//分钟的顾客就会不满意，不生气则他们是满意的。
//
// 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
//
// 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
//
//
// 示例：
//
// 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
// 1 1 1 1 7 5
//输出：16
//解释：
//书店老板在最后 3 分钟保持冷静。
//感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
//
//
//
// 提示：
//
//
// 1 <= X <= customers.length == grumpy.length <= 20000
// 0 <= customers[i] <= 1000
// 0 <= grumpy[i] <= 1
//
// Related Topics 数组 Sliding Window
// 👍 132 👎 0

package leetcode.editor.cn;
public class GrumpyBookstoreOwner {
    public static void main(String[] args) {
        Solution solution = new GrumpyBookstoreOwner().new Solution();
        int[] customers = {1,0,1,2,1,1,7,5};
        int[] grumpy = {0,1,0,1,0,1,0,1};
        System.out.println(solution.maxSatisfied(customers, grumpy, 3));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int count = 0;
        int n = customers.length;
        //求所有老板不生气的时候所有的符合条件的顾客，并将原满意顾客数设置为0
        for (int i=0;i<n;i++) {
            if (grumpy[i] == 0) {
                count +=customers[i];
                customers[i] = 0;
            }
        }

        //求连续长度为X在customers中的最大长度
        int tmp=0, max=0, i=0;
        while (i < n){
            if (i < X)
                tmp += customers[i];
            else
                tmp += customers[i] - customers[i - X];
            max = Math.max(max, tmp);
            i++;
        }

        return count + max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
