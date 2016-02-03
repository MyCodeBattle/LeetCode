/*
 * 依次取.之前的数字来判断。
 */

public class Solution {
    public int compareVersion(String version1, String version2) {
        int previousPos1 = -1, previousPos2 = -1;
        while (!version1.isEmpty() && !version2.isEmpty()) {
            int dotPos1 = version1.indexOf('.', previousPos1 + 1);
            if (dotPos1 == -1)
                dotPos1 = version1.length();
            int dotPos2 = version2.indexOf('.', previousPos2 + 1);
            if (dotPos2 == -1)
                dotPos2 = version2.length();

            int num1 = previousPos1 == version1.length() ? 0 : Integer.parseInt(version1.substring(previousPos1 + 1, dotPos1));
            int num2 = previousPos2 == version2.length() ? 0 : Integer.parseInt(version2.substring(previousPos2 + 1, dotPos2));
            

            if (num1 > num2)
                return 1;
            else if (num1 < num2)
                return -1;

            previousPos1 = dotPos1;
            previousPos2 = dotPos2;
            if (previousPos1 == version1.length() && previousPos2 == version2.length())
                return 0;
        }
        return 0;
    }
}
