package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * <p>Title: </p>
 * <p>Description: 理论上可以使用递归完后的操作都可以使用栈来实现，此处实现栈实现树的前序遍历</p>
 *
 * @author kaiz
 * @date 13:25 2019-06-10.
 */
public class TreeTraversWithStack {
    private static class TreeNode{
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data){
            this.data = data;
        }
    }

    public static TreeNode createBinarytree(LinkedList<Integer> inputList){
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()){
            return  null;
        }
        Integer data = inputList.removeFirst();
        if (data != null){
            node = new TreeNode(data);
            node.leftChild = createBinarytree(inputList);
            node.rightChild = createBinarytree(inputList);
        }
        return node;
    }

    public static void preOrderTraveralWithStack(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()){
            //迭代访问节点的左孩子，并入栈
            while (treeNode != null){
                System.out.println(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            //如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
            if (!stack.isEmpty()){
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{3,2,9,null,null,10,null,null,8,null,4}));
        System.out.println("开始构建二叉树");
        TreeNode treeNode = createBinarytree(inputList);
        System.out.println("构建二叉树完毕");
        System.out.println("二叉树前序遍历");
        preOrderTraveralWithStack(treeNode);
    }

}
