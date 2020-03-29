package leetcode.simple;


/**
 * <p>Title: </p>
 * <p>Description:
 * 实现一种算法，删除单向链表中间的某个节点（除了第一个和最后一个节点，不一定是中间节点），假定你只能访问该节点。
 * 输入：单向链表a->b->c->d->e->f中的节点c
 * 结果：不返回任何数据，但该链表变为a->b->d->e->f
 * </p>
 * @author kaiz
 * @date 19:47 2020-02-19.
 */
public class DeleteMiddleNode {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
    * <p>Title: </p>
    * <p>Description: 将下一节点替换当前节点</p>
    * @Author:kaiz
     * @param node :
    * @return: void
    * @Date: 2020-02-19 20:15
    */
    public static void deleteNode(ListNode node) {
        ListNode nextNode = node.next;
        if (nextNode != null){
            node.val = nextNode.val;
            while (nextNode.next != null){
                node.next = nextNode.next;
                nextNode = nextNode.next;
                node = nextNode;
            }
            node.next = null;
        }

    }

    public static void main(String[] args) {
        String[] a = new String[2];
        Object[] b = a;
        a[0] = "hi";
        b[1] = Integer.valueOf(42);
    }


}
