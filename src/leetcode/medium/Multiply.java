package leetcode.medium;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 *
 * @author kaiz
 * @date 5:21 PM 2/26/21.
 */
public class Multiply {
    public static void main(String[] args) {
//        System.out.println(multiply(1,10));
        System.out.println(multiply(1,2147483647));

    }

    public static int multiply(int A, int B) {
        if(B==0){return 0;}
        return A+multiply(A,B-1);
    }
}
