/*
 * 我们增加一个空的头就行了，判断一下后两个是不是都有数存在，然后随便搞搞。
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
    ListNode* swapPairs(ListNode* head) {
        ListNode *dummy = new ListNode(0);
        dummy->next = head;
        ListNode *cur = dummy;
        while (cur->next != nullptr && cur->next->next != nullptr) {
            //可以互换接下来两位
            ListNode *lhs = cur->next, *rhs = cur->next->next;
            lhs->next = rhs->next;
            rhs->next = lhs;
            cur->next = rhs;
            cur = cur->next->next;
        }
        return dummy->next;
    }
};
