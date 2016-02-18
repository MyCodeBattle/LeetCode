/*
 * 简单模拟，错了好多次_(:3」∠)_
 */

public class Solution {
    public String getHint(String secret, String guess) {
        int[] map = new int[10];

        int A = 0, B = 0;
        for (int i = 0; i < secret.length(); ++i) {
            ++map[secret.charAt(i) - '0'];
            if (secret.charAt(i) == guess.charAt(i)) {
                --map[secret.charAt(i) - '0'];
                ++A;
            }
        }
        for (int i = 0; i < secret.length(); ++i) {
            if (guess.charAt(i) != secret.charAt(i) && map[guess.charAt(i) - '0'] > 0 ) {
                --map[guess.charAt(i) - '0'];
                ++B;
            }
        }
        return A + "A" + B + "B";
    }
}
