/*
 * 很神奇的思路。
 * O(n)。
 * 同样也是维护k大小的窗口。
 * 我们可以用桶排对t范围的数进行划分。
 * 每拿到一个数时，先看他直接对应的桶里有没有数，如果有的话就是符合条件的。
 * 如果上一步没有，查看前一个桶和后一个桶，这时就要判断条件了，因为这两个桶里不一定就是相差t之内。
 * 然后把这个数放到桶里。
 * 
 * 另外一种思路就是用TreeSet，类似C++ STL里的lower_bound来查找num-t, num+t之间是否存在数，O(nlogk)
 *
 */

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Long, Long> map = new HashMap<>();
        if (k < 1 || t < 0)
            return false;

        for (int i = 0; i < nums.length; ++i) {
            long newNumber = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = newNumber/((long)t + 1);
            if (map.containsKey(bucket) || (map.containsKey(bucket - 1) && newNumber - map.get(bucket - 1) <= t) || (map.containsKey(bucket + 1) && map.get(bucket + 1) - newNumber <= t))
                return true;
            if (map.size() == k)
                map.remove(((long) nums[i - k] - Integer.MIN_VALUE) / ((long)t + 1));
            map.put(bucket, newNumber);
        }
        return false;
    }
}

