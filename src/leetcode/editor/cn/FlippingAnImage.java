//给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
//
// 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
//
// 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
//
// 示例 1:
//
//
//输入: [[1,1,0],[1,0,1],[0,0,0]]
//输出: [[1,0,0],[0,1,0],[1,1,1]]
//解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
//     然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
//
//
// 示例 2:
//
//
//输入: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
//输出: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
//解释: 首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
//     然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
//
// 说明:
//
//
// 1 <= A.length = A[0].length <= 20
// 0 <= A[i][j] <= 1
//
// Related Topics 数组
// 👍 209 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class FlippingAnImage {
    public static void main(String[] args) {
        Solution solution = new FlippingAnImage().new Solution();
        int[][] A = {{1,1,0},{1,0,1},{0,0,0}};
        int[][] result = solution.flipAndInvertImage(A);
        for (int i=0;i<result.length;i++) {
            int[] a = result[i];
            for (int value : a) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        //        int n = A.length;
//        for (int i=0; i< n; i++) {
//            int[] arr = A[i];
//            //逆序
//            int temp = 0;
//            for (int j = 0; j < arr.length / 2; j++) {
//                temp = arr[j];
//                arr[j] = arr[arr.length - j - 1];
//                arr[arr.length - j - 1] = temp;
//            }
//            //0变1，1变0
//            for (int k =0;k<arr.length;k++) {
//                if (arr[k] == 0)
//                    arr[k] = 1;
//                else
//                    arr[k] = 0;
//            }
//            A[i] = arr;
//        }
        int m = 0,n = 0;
        for (int i=0;i < A.length; i++) {
            for (int a = 0,b=A[i].length-1; a<=b; a++, b--) {
                m = A[i][a];
                n = A[i][b];
                A[i][a] = n ^ 1;
                A[i][b] = m ^ 1;
            }
        }
        return A;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


}
