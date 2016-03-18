/*
 * 本来想实现一个类似选择排序一样，不停交换相邻的swap函数，但是感觉太麻烦了。
 * 我们可以想象一下，k个结点翻转，1->2->3，就相当于1<-2<-3，把指针方向改一下就行，那么我们就可以用两个指针一前一后，把后面的next盖到前面就可以了。
 */

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    
    bool advance(ListNode *cur, ListNode *&next_node, int k) {
        while (k--) {
            if (cur == nullptr)
                return false;
            cur = cur->next;
        }
        this.next_node = cur;
        return cur != nullptr;
    }

    void solve(ListNode *cur_node, ListNode *next_node) {
        ListNode *l = cur_node->next, *r = cur_node->next->next;
        while (true) {
            ListNode *tmp = r->next; //保护一下下一个
            r->next = l;
            l = r;
            r = tmp;
            if (l == next_node) {
                cur_node->next->next = tmp;
                cur_node->next = l;
                return;
            }
        }
    }

    ListNode* reverseKGroup(ListNode* head, int k) {
        if (k <= 1)
            return head;
        ListNode *dummy = new ListNode(0), *cur_node = dummy;
        dummy->next = head;
        ListNode *next_node = nullptr;
        while (advance(cur_node, next_node, k)) {  //如果接下来有k个结点
            solve(cur_node, next_node);
            advance(cur_node, next_node, k);
            cur_node = next_node;
        }
        return dummy->next;
    }
};
