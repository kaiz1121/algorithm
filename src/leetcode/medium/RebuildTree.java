package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 *
 * @author kaiz
 * @date 14:13 2020-03-11.
 */
public class RebuildTree {
  /*
   前序遍历 preorder = [3, 9, 20,15,7]
   中序遍历 inorder = [9,3,15,20,7]
     3
    / \
   9  20
     /  \
    15   7

 */
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || preorder.length == 0){
                return null;
            }
            int treeLength = preorder.length;
            //value为前置排序下标
            Map<Integer, Integer> treeMap = new HashMap<>(treeLength);
            for (int i=0; i< treeLength; i++){
                treeMap.put(inorder[i], i);
            }
            //根节点位置，左侧为左树，右侧为右树
            return recursiveTree(0, 0, inorder.length -1, treeMap, preorder);
        }

        /**
        * <p>Title: recursiveTree</p>
        * <p>Description: </p>
        * @Author:kaiz
         * @param preRootIndex : 前序排列中根节点下标
         * @param inLeftIndex : 中序排列中的最左元素下标
         * @param inRightIndex : 中序排列中的最右元素下标
         * @param treeMap : key为中序排列中节点数据值，value为值的下标
         * @param preorder : 前序排列数组
        * @return: leetcode.medium.RebuildTree.Solution.TreeNode
        * @Date: 2020-03-15 22:20
        */
        TreeNode recursiveTree(int preRootIndex, int inLeftIndex, int inRightIndex, Map<Integer, Integer> treeMap, int[] preorder){
            //出口
            if (inLeftIndex > inRightIndex)
                return null;
            //根节点
            TreeNode treeNode = new TreeNode(preorder[preRootIndex]);
            //根节点在中序排序中的索引
            int inOrderRootIndex = treeMap.get(preorder[preRootIndex]);
            //根据中序排序获取左子树和右子树
            //左子树在前序中根节点的元素下标: preRootIndex + 1
            //左子树的右侧范围是中序排列中根节点的位置-1
            treeNode.left = recursiveTree(preRootIndex + 1, inLeftIndex, inOrderRootIndex -1, treeMap, preorder);
            //右子树的前序中根节点的元素下标: 前序排列中根节点下标(preRootIndex) + 左子树的长度(inOrderRootIndex - inRightIndex) 加 1
            treeNode.right = recursiveTree(preRootIndex + inOrderRootIndex - inLeftIndex + 1, inOrderRootIndex + 1, inRightIndex, treeMap, preorder);
            return treeNode;
        }

        class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) { val = x; }
        }
    }
}
