/*
 * 我们用优先队列存一下边，然后dfs一下，最后reverse一下就行。
 */

public class Solution {
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    List<String> ans = new ArrayList<>();

    private void dfs(String city) {
        while (map.containsKey(city) && !map.get(city).isEmpty()) {
            String next = map.get(city).poll();
            dfs(next);
        }
        ans.add(city);
    }

    public List<String> findItinerary(String[][] tickets) {

        for (String[] ticket : tickets) {
            if (!map.containsKey(ticket[0]))
                map.put(ticket[0], new PriorityQueue<String>());
            map.get(ticket[0]).offer(ticket[1]);
        }
        dfs("JFK");
        Collections.reverse(ans);
        return ans;
    }
}
