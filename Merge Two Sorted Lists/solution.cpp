/*
 * 随便搞搞。
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
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode *pos1 = l1, *pos2 = l2;
        ListNode *ret = new ListNode(0), *head = ret;
        while (pos1 != nullptr || pos2 != nullptr) {
            if (pos1 != nullptr && pos2 != nullptr) {
                if (pos1->val > pos2->val) {
                    ret->next = new ListNode(pos2->val);
                    pos2 = pos2->next;
                }
                else {
                    ret->next = new ListNode(pos1->val);
                    pos1 = pos1->next;
                }
            }
            else if (pos1 == nullptr) {
                ret->next = new ListNode(pos2->val);
                pos2 = pos2->next;
            }
            else {
                ret->next = new ListNode(pos1->val);
                pos1 = pos1->next;
            }
            ret = ret->next;
        }
        return head->next;
    }
};

