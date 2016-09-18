public class Solution {
    private int[] C;
    private int MAXN;

    private int query(int pos) {
        int ret = 0;
        while (pos != 0) {
            ret += C[pos];
            pos -= lowbit(pos);
        }
        return ret;
    }

    private void add(int pos) {
        while (pos < MAXN) {
            C[pos]++;
            pos += lowbit(pos);
        }
    }

    private int lowbit(int n) {
        return n & (-n);
    }

    private void reverse(int[] nums) {
        int l = 0, r = nums.length - 1;
        for (; l < r; ++l, --r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        C = new int[nums.length + 10];
        MAXN = nums.length + 10;

        List<Integer> arr = new ArrayList<>();
        for (int v : nums) {
            arr.add(v);
        }
        Collections.sort(arr);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.size(); ++i) {
            if (!map.containsKey(arr.get(i))) {
                map.put(arr.get(i), map.size() + 1);
            }
        }

        for (int i = 0; i < nums.length; ++i) {
            nums[i] = map.get(nums[i]);
        } 
        
        List<Integer> ans = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; --i) {
            ans.add(query(nums[i] - 1));
            add(nums[i]);
        }

        Collections.reverse(ans);
        return ans;
    }
}
