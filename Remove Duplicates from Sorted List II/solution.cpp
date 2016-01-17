/*
 * 用指针扫描一遍，记录一下上个指针，一边维护一下上个数值的出现次数。
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
        ListNode *dummy = new ListNode(0), *pos = dummy;
        ListNode *cur = head, *last_pointer;
        int last_val, cnt = 0;
        for (; cur; cur = cur->next) {
            if (cur != head && cur->val == last_val) {
                ++cnt;
                continue;
            }
            if (cnt == 1) {
                pos->next = last_pointer;
                pos = pos->next;
                pos->next = nullptr;
            }
            cnt = 0;
            last_val = cur->val;
            last_pointer = cur;
            ++cnt;
        }
        if (cnt == 1) {
            pos->next = last_pointer;
            pos->next->next = nullptr;
        }
        return dummy->next;
    }
};
