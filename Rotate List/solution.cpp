/*
 * 找到切断的那个点，随便指一下就行。
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
    ListNode *head, *connect;
    int save;

    void dfs(ListNode *cur, int num) {
        if (num == save) {
            this->head = cur->next;
            cur->next = nullptr;
            return;
        }
        dfs(cur->next, num + 1);
    }

    int get_len(ListNode *cur) {
        if (cur->next == nullptr) {
            connect = cur;
            return 1;
        }
        return get_len(cur->next) + 1;
    }

    ListNode* rotateRight(ListNode* head, int k) {
        if (head == nullptr)
            return head;
        int len = get_len(head);
        k %= len;
        if (k == 0)
            return head;
        save = len - k;
        dfs(head, 1);
        connect->next = head;
        return this->head;
    }
};
