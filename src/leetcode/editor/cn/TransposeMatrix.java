//给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
//
// 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
//
//
//
//
//
// 示例 1：
//
//
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[1,4,7],[2,5,8],[3,6,9]]
//
//
// 示例 2：
//
//
//输入：matrix = [[1,2,3],[4,5,6]]
//输出：[[1,4],[2,5],[3,6]]
//
//
//
//
// 提示：
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 1000
// 1 <= m * n <= 105
// -109 <= matrix[i][j] <= 109
//
// Related Topics 数组
// 👍 154 👎 0

package leetcode.editor.cn;
public class TransposeMatrix {
    public static void main(String[] args) {
        Solution solution = new TransposeMatrix().new Solution();
        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] b = {{1,2,3},{4,5,6}};

        int[][] result1 = solution.transpose(a);
        for (int i =0;i<result1.length;i++) {
            for (int j =0;j<result1[i].length;j++) {
                System.out.print(result1[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("------------------------------------------");

        int[][] result2 = solution.transpose(b);

        for (int i =0;i<result2.length;i++) {
            for (int j =0;j<result2[i].length;j++) {
                System.out.print(result2[i][j] + " ");
            }
            System.out.println();
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] transpose(int[][] matrix) {
        int n = matrix.length;
        int[][] result = new int[matrix[0].length][n];
        for (int i=0; i< n; i++) {
            int[] arr = matrix[i];
            for (int j=0; j < arr.length; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
