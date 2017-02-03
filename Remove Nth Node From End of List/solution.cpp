/*
 * 随便搞搞
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
    ListNode *head;

    ListNode *remove(ListNode *cur, int cur_pos, int tar_pos) {
        if (cur_pos + 1 == tar_pos) {
            cur->next = cur->next->next;
        }
        else {
            remove(cur->next, cur_pos + 1, tar_pos);
        }
        return cur;
    }

    int get_len(ListNode *cur) {
        if (cur == nullptr) {
            return 0;
        }
        return 1 + get_len(cur->next);
    }

    ListNode* removeNthFromEnd(ListNode* head, int n) {
        if (n == 0) {
            return head;
        }
        this->head = head;
        int len = get_len(head);
        int pos = len - n;
        if (pos == 0) {
            return head->next;
        }
        return remove(head, 0, pos);
    }
};
