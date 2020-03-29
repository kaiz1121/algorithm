package leetcode.medium;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 *求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 示例 1：
 *
 * 输入: n = 3
 * 输出: 6  (1+2+3)
 * 示例 2：
 *
 * 输入: n = 9
 * 输出: 45(1+2+3+4+5+6+7+8+9)= (1+9) + (2+8 ) + (3+7) + (4+6) + 5  = (9+1) * ((9-1)/2) +5

 *
 * x的n次方为y,n = Math.log(y)/Math.log(x);
 * //左移 num << n : num乘以 2的n次方
 * //右移 num >> n : num除以 2的n次方
 *
 * 限制：
 * 1 <= n <= 10000
 * @author kaiz
 * @date 22:50 2020-03-17.
 */
public class SumNums {

    //
    public static int sumNums(int n) {
        return (int) (Math.pow(n, 2) + n) >> 1;
    }

    public static void main(String[] args) {
        System.out.println(sumNums(9));
        System.out.println(sumNums(8));
        System.out.println(sumNums(3));
        System.out.println(sumNums(7));


//        System.out.println(9 >> 1);
    }
}
