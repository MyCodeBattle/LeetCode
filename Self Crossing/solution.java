/*
 * 细节题，太可怕了。。
 * 复制一下@niwota 的图，非常直观。
 *
 *                i-2
    case 1 : i-1┌─┐
                └─┼─>i
                 i-3

                    i-2
    case 2 : i-1 ┌────┐
                 └─══>┘i-3
                 i  i-4      (i overlapped i-4)

    case 3 :    i-4
               ┌──┐ 
               │i<┼─┐
            i-3│ i-5│i-1
               └────┘
                i-2


*
* 总共就这三种相交的情况，特判即可。
*/

public class Solution {
    public boolean isSelfCrossing(int[] x) {
        if (x.length < 4)
            return false;

        for (int i = 3; i < x.length; ++i) {
            if (x[i] >= x[i - 2] && x[i - 1] <= x[i - 3])
                return true;
            else if (i >= 4 && x[i - 1] == x[i - 3] && x[i] + x[i - 4] >= x[i - 2])
                return true;
            else if (i >= 5 && x[i - 2] >= x[i - 4] && x[i - 1] <= x[i - 3] && x[i - 3] - x[i - 5] <= x[i - 1] && x[i - 2] - x[i - 4] <= x[i])
                return true;
        }
        return false;
    }
}

