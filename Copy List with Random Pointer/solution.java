/*
 * 和之前的copy图道理一样。
 */

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    Map<Integer, RandomListNode> map = new HashMap<>();

    RandomListNode clone(RandomListNode head) {
        if (head == null)
            return null;
        if (map.containsKey(head.label))
            return map.get(head.label);
        RandomListNode newNode = new RandomListNode(head.label);
        map.put(newNode.label, newNode);

        newNode.next = clone(head.next);
        newNode.random = clone(head.random);
        return newNode;
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        return clone(head);
    }
}
