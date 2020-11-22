//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//
//
// 示例：
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
//
// Related Topics 链表
// 👍 1392 👎 0

package leetcode.editor.cn;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
//        ListNode l1 = new ListNode(1);
//        ListNode l1_next1 = new ListNode(2);
//        l1_next1.next = new ListNode(4);
//        l1.next = l1_next1;
//        ListNode l2 = new ListNode(1);
//        ListNode l2_next1 = new ListNode(3);
//        l2_next1.next = new ListNode(4);
//        l2.next = l2_next1;
//        ListNode mergeList = solution.mergeTwoLists(l1, l2);
//        ListNode tmp = mergeList;
//        while (tmp != null) {
//            System.out.println(tmp.val);
//            tmp = tmp.next;
//        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 迭代的思路，先找到每次找到l1,l2值较小的，作为哨兵节点的next，
         * 直到最后其中一个子链表为空 直接拼接到最后即可
         *
         * @param l1
         * @param l2
         * @return
         */
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode rootNode = new ListNode(0);
            ListNode tmpRoot = rootNode;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    tmpRoot.next = l1;
                    l1 = l1.next;
                } else {
                    tmpRoot.next = l2;
                    l2 = l2.next;
                }
                tmpRoot = tmpRoot.next;
            }
            tmpRoot.next = l1 != null ? l1 : l2;
            return rootNode.next;

        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
