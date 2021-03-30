 //给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
//
//
//
// 示例 1：
//
//
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
//
//
// 示例 2：
//
//
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
//
//[[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]
/*
[1, 2, 3, 4]
[5, 6, 7, 8]
[9, 10,11,12]
[13,14,15,16]

1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10
 */
//
//
// 提示：
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 10
// -100 <= matrix[i][j] <= 100
//
// Related Topics 数组
// 👍 652 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> r = solution.spiralOrder(arr);
        for (Integer i : r) {
            System.out.println(i);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*
        从左到右遍历上侧元素，依次为(top,left) 到 (top,right)。
        从上到下遍历右侧元素，依次为(top+1,right) 到(bottom,right)。
        若left<right 且top<bottom，则从右到左遍历下侧元素，依次为(bottom,right−1) 到(bottom,left+1)，
        以及从下到上遍历左侧元素，依次为(bottom,left) 到(top+1,left)。

         */
        public List<Integer> spiralOrder(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            List<Integer> result = new ArrayList<>(m * n);
            int top = 0, left = 0, right = n - 1, low = m - 1;
            while (left <= right && top <= low) {
                for (int i = left; i <= right; i++) {
                    result.add(matrix[top][i]);
                }
                for (int i = top + 1; i <= low; i++) {
                    result.add(matrix[i][right]);
                }
                if (left < right && top < low) {
                    for (int i = right - 1; i > left; i--) {
                        result.add(matrix[low][i]);
                    }
                    for (int i = low; i>top; i--) {
                        result.add(matrix[i][left]);
                    }
                }
                left++;
                top++;
                right--;
                low--;
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
