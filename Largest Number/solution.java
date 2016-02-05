/*
 * 自定义比较，把两个数字前后分别加起来比一下。
 */

public class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null)
            return "";
        String[] str = new String[nums.length];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nums.length; ++i)
            str[i] = nums[i] + "";

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s2.compareTo(s1);
            }
        });

        if (str[0].charAt(0) == '0')
            return "0";

        for (String s : str)
            sb.append(s);
        return sb.toString();
    }
}
