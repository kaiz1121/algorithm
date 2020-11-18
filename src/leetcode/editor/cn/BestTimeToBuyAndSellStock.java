//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//
// 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
//
// 注意：你不能在买入股票前卖出股票。
//
//
//
// 示例 1:
//
// 输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
//
//
// 示例 2:
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
//
// Related Topics 数组 动态规划
// 👍 1270 👎 0

package leetcode.editor.cn;


public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStock().new Solution();
        int[] prices1 = {7,13,1, 5, 3, 6, 4};
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println(solution.maxProfit2(prices1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /*
    双重循环暴力穷举
    使用两层循环，依次在每个节点买入，然后再在之后的所有节点卖出，这样来计算节点间的差值（收益），
    如果此差值大于当前最高收益，就将此值设置为当前最高收益，这样循环完，我们就能获得最大收益
     */
        //7, 1, 5, 3, 6, 4
        public int maxProfit1(int[] prices) {
            int maxprofit = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    int profit = prices[j] - prices[i];
                    if (profit > maxprofit) {
                        maxprofit = profit;
                    }
                }
            }
            return maxprofit;
        }
        //7, 1, 5, 3, 6, 4
        //贪心算法，只关心局部最优解。
        //所谓的最大利润就是找到一个最小值prices[i]，最大值prices[j]，并且下标i<j
        //遍历一遍数组，不断更新最小值，再计算出max(当前值-最小值) 即为最终结果。
        public int maxProfit2(int[] prices) {
            int maxProfit = 0;
            int minPrice = Integer.MAX_VALUE;
            for (int currentPrice : prices) {
                if (minPrice > currentPrice) {
                    minPrice = currentPrice;
                    System.out.println("minPrice:" + minPrice);
                }
                maxProfit = Math.max(maxProfit, currentPrice - minPrice);
                System.out.println("maxProfit:" + maxProfit);
            }
            return maxProfit;
        }


        //动态规划,空间换时间
        public int maxProfit3(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int n = prices.length;
            //创建两个数组，一个记录每次卖出的最大收益，一个记录每次买入最大收益
            int[] sell = new int[n];
            int[] buy = new int[n];
            //初始化第一天收益
            sell[0] = 0;
            buy[0] = -prices[0];
            for (int i = 1; i < n; ++i) {
                //第i天卖出收益 = max(第i-1天卖出收益，第i-1天买入收益+当天股价)
                sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
                //第i天买入收益 = max(第i-1天买入收益，-当天股价)
                buy[i] = Math.max(buy[i - 1], -prices[i]);
            }
            return Math.max(sell[n - 1], buy[n - 1]);
        }
    }

}
