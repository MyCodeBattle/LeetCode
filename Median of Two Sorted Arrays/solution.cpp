#include <stack>
#include <cstdio>
#include <list>
#include <cassert>
#include <set>
#include <iostream>
#include <string>
#include <sstream>
#include <vector>
#include <queue>
#include <functional>
#include <cstring>
#include <algorithm>
#include <cctype>
//#pragma comment(linker, "/STACK:102400000,102400000")
#include <string>
#include <map>
#include <cmath>
using namespace std;
#define LL long long
#define ULL unsigned long long
#define SZ(x) (int)x.size()
#define Lowbit(x) ((x) & (-x))
#define MP(a, b) make_pair(a, b)
#define MS(p, num) memset(p, num, sizeof(p))
#define PB push_back
#define X first
#define Y second
#define ROP freopen("input.txt", "r", stdin);
#define MID(a, b) (a + ((b - a) >> 1))
#define LC rt << 1, l, mid
#define RC rt << 1|1, mid + 1, r
#define LRT rt << 1
#define RRT rt << 1|1
#define FOR(i, a, b) for (int i=(a); (i) < (b); (i)++)
#define FOOR(i, a, b) for (int i = (a); (i)<=(b); (i)++)
const double PI = acos(-1.0);
const int INF = 0x3f3f3f3f;
const double eps = 1e-8;
const int MAXN = 1e5+10;
const int MOD = 1e9 + 7;
const int dir[][2] = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
const int seed = 131;
int cases = 0;
typedef std::pair<int, int> pii;

class Solution {
public:
    int all;
    bool rec1, rec2, use;
    void check(vector<int> &nums, int pos, int &ans1, int &ans2) {
        if (rec2) {
            ans2 = nums[pos-1];
            use = true;
            return;
        }
        if (rec1) {
            ans1 = nums[pos-1];
            if (!(all & 1)) {
                rec2 = true;
            }
        }
    }

    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        all = nums1.size() + nums2.size();
        rec1 = rec2 = false;
        use = false;
        int mid = (all + 1) / 2;
        int cnt = 0, ans1, ans2, pos1 = 0, pos2 = 0;
        for (int i = 0; i < nums1.size() + nums2.size(); i++) {
            if (++cnt == mid) {
                rec1 = true;
            }
            if (pos1 != nums1.size() && pos2 != nums2.size()) {
                if (nums1[pos1] >= nums2[pos2]) {
                    ++pos2;
                    check(nums2, pos2, ans1, ans2);
                }
                else {
                    ++pos1;
                    check(nums1, pos1, ans1, ans2);
                }
            }
            else if (pos1 != nums1.size()) {
                ++pos1;
                check(nums1, pos1, ans1, ans2);
            }
            else if (pos2 != nums2.size()) {
                ++pos2;
                check(nums2, pos2, ans1, ans2);
            }
            if (rec1) {
                if (rec2 && use) {
                    return (ans1*1.0 + ans2) / 2;
                }
                else if (!rec2) {
                    return ans1;
                }
            }
        }
    }
};



