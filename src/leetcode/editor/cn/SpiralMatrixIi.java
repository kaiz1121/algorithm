//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
//
//
//
// 示例 1：
//
//
//输入：n = 3
/**
 * 1 2 3
 * 8 9 4
 * 7 6 5
 */
//输出：[[1,2,3],[8,9,4],[7,6,5]]
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：[[1]]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 20
//
// Related Topics 数组
// 👍 339 👎 0

package leetcode.editor.cn;
public class SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
        int[][] result = solution.generateMatrix(1);
        for (int i=0;i<result.length;i++) {
            for (int j=0;j<result[0].length;j++) {
                System.out.println(result[i][j]);
            }
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int value = 1;
        int[][] result = new int[n][n];
        int top = 0,left=0,low = n-1,right = n-1;
        while (top <= low && left <= right) {
            for (int i = left; i<=right;i++) {
                result[top][i] = value++;
            }
            for (int i=top+1; i<=low;i++) {
                result[i][right] = value++;
            }

            if (top < low && left < right) {
                for (int i=right-1; i>left; i--) {
                    result[low][i] = value++;
                }
                for (int i=low; i>top; i--) {
                    result[i][left] = value++;
                }
            }

            top++;
            low--;
            left++;
            right--;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
