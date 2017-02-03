//逐层递归，把数都加在p2上，有时需要扩展p2的，处理一下有进位的情况


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
    ListNode *get_num(ListNode *p1, ListNode *p2, int add)
    {
        if (p1 == NULL && p2 == NULL)
        {
            if (add) p2 = new ListNode(add);
            return p2;
        }
        if (p1 != NULL && p2 != NULL)
        {
            p2->val += p1->val + add;
            add = p2->val / 10;
            p2->val %= 10;
        }
        else if (p1 != NULL && p2 == NULL)
        {
            int num = p1->val + add;
            add = num / 10;
            num %= 10;
            p2 = new ListNode(num);
        }
        else
        {
            p2->val += add;
            add = p2->val / 10;
            p2->val %= 10;
        }
        if (p2->next == NULL) p2->next = get_num(p1 ? p1->next : p1, p2->next, add);
        else get_num(p1 ? p1->next : p1, p2->next, add);
        return p2;
    }

    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        return get_num(l1, l2, 0);
    }
};


