/*
 * 随便接一下就行。
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
    ListNode* deleteDuplicates(ListNode* head) {
        if (head == nullptr)
            return head;
        ListNode *ans = new ListNode(0), *pos = ans;
        ListNode *cur = head;
        while (cur) {
            if (cur != head && cur->val == pos->val) {
                cur = cur->next;
                continue;
            }
            pos->next = cur;
            cur = cur->next;
            pos = pos->next;
            pos->next = nullptr;
        }
        return ans->next;
    }
};
