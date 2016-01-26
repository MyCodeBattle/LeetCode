/*
 * 也是很神奇的一题，原理是层次遍历，用两个指针模拟队列，在当前层遍历，搞好下一层的next。然后转到下一层，依次循环。
 */

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {

    public void connect(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode head = new TreeLinkNode(0);
            TreeLinkNode currentPos = head;
            while (root != null) {
                if (root.left != null) {
                    currentPos.next = root.left;
                    currentPos = root.left;
                }
                if (root.right != null) {
                    currentPos.next = root.right;
                    currentPos = root.right;
                }
                root = root.next;
            }
            root = head.next;
        }
    }
}
