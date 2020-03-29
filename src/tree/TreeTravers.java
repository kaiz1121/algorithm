package tree;



import java.util.Arrays;
import java.util.LinkedList;

/**
 * <p>Title: </p>
 * <p>Description: 使用递归方式完成树的前中后序遍历</p>
 *
 * @author kaiz
 * @date 12:31 2019-06-10.
 */
public class TreeTravers {

    private static class TreeNode{
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data){
            this.data = data;
        }
    }

    /**
    * <p>Title: createBinarytree</p>
    * <p>Description: 构建二叉树</p>
    * @Author:kaiz
     * @param inputList :
    * @return: tree.TreeTravers.TreeNode
    * @Date: 2019-06-10 12:41
    */
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


    /**
    * <p>Title: preOrderTraveral</p>
    * <p>Description: 前序遍历</p>
    * @Author:kaiz
     * @param node :
    * @return: void
    * @Date: 2019-06-10 13:02
    */
    public static void preOrderTraveral(TreeNode node){
        if (node == null){
            return;
        }
        System.out.println(node.data);
        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightChild);
    }

    /**
    * <p>Title:inOrderTraveral </p>
    * <p>Description: 中序遍历</p>
    * @Author:kaiz
     * @param node :
    * @return: void
    * @Date: 2019-06-10 13:05
    */
    public static void inOrderTraveral(TreeNode node){
        if (node == null){
            return;
        }
        inOrderTraveral(node.leftChild);
        System.out.println(node.data);
        inOrderTraveral(node.rightChild);
    }


    /**
    * <p>Title: postOrderTraveral</p>
    * <p>Description: 后序遍历</p>
    * @Author:kaiz
     * @param node :
    * @return: void
    * @Date: 2019-06-10 13:05
    */
    public static void postOrderTraveral(TreeNode node){
        if (node == null){
            return;
        }
        postOrderTraveral(node.leftChild);
        postOrderTraveral(node.rightChild);
        System.out.println(node.data);
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{3,2,9,null,null,10,null,null,8,null,4}));
        System.out.println("开始构建二叉树");
        TreeNode treeNode = createBinarytree(inputList);
        System.out.println("构建二叉树完毕");
        System.out.println("二叉树前序遍历");
        preOrderTraveral(treeNode);
        System.out.println("二叉树中序遍历");
        inOrderTraveral(treeNode);
        System.out.println("二叉树后序遍历");
        postOrderTraveral(treeNode);


    }



}
