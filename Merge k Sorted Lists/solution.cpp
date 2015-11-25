/*
 * 容易想到用优先队列维护该从哪个链表里取数字，然后看情况push下一个就行。
 */

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

struct cmp
{
    bool operator () (ListNode *a, ListNode *b) {
        return a->val > b->val;
    }
};

class Solution {
public:
    priority_queue<ListNode*, vector<ListNode*>, cmp> Q;

    ListNode* mergeKLists(vector<ListNode*>& lists) {
        ListNode *ret = new ListNode(0), *head = ret;
        for (int i = 0; i < lists.size(); i++) {
            if (lists[i] != nullptr)
                Q.push(lists[i]);
        }
        while (!Q.empty()) {
            ListNode *cur = Q.top(); Q.pop();
            ret->next = cur;
            if (cur->next != nullptr)
                Q.push(cur->next);
            ret = ret->next;
        }
        return head->next;
    }
};
