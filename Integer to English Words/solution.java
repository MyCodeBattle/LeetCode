/*
 * 分成三位三位处理。
 */

public class Solution {
    String[] small = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] middle = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] big = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {

        if (num == 0)
            return "Zero";

        int cnt = 0;
        String words = "";
        while (num != 0) {
            if (num % 1000 != 0)
                words = helper(num % 1000).trim() + " " + big[cnt] + " "  + words;
            num /= 1000;
            ++cnt;
        }
        return words.trim();
    }

    private String helper(int n) {
        if (n < 20)
            return small[n];
        else if (n < 100)
            return middle[n / 10] + " " + small[n % 10];
        return helper(n / 100).trim() + " Hundred " + helper(n % 100);
    }
}
