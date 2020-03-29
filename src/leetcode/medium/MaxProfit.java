package leetcode.medium;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 *假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *  
 *
 * 限制：
 * 0 <= 数组长度 <= 10^5
 * @author kaiz
 * @date 22:15 2020-03-17.
 */
public class MaxProfit {

    //动态规划
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0){
            return 0;
        }
        int minProfit = prices[0];
        int result = 0;
        for (int i=1; i<=prices.length-1; i++){
            if (prices[i] < minProfit){
                minProfit = prices[i];
            }else {
                //状态转移方程
                result = Math.max(result, prices[i] - minProfit);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int[] proces2 = {7,6,4,3,1};
        System.out.println(maxProfit(proces2));
    }
}
