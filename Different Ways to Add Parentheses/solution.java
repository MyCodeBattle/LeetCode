/*
 * 考虑每个符号的贡献，递归两边的答案，然后相乘即可。
 */

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ret = new ArrayList<>();
        if (input.isEmpty())
            return ret;

        for (int i = 0; i < input.length(); ++i) {
            char cha = input.charAt(i);
            if (cha == '+' || cha == '-' || cha == '*') {
                List<Integer> ans1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> ans2 = diffWaysToCompute(input.substring(i + 1));
                for (int num1 : ans1) {
                    for (int num2 : ans2) {
                        int currentNum = 0;
                        if (cha == '+')
                            currentNum = num1 + num2;
                        else if (cha == '-')
                            currentNum = num1 - num2;
                        else if (cha == '*')
                            currentNum = num1 * num2;
                        ret.add(currentNum);
                    }
                }
            }
        }
        if (ret.isEmpty())
            ret.add(Integer.parseInt(input));
        return ret;
    }
}
