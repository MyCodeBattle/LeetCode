public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Integer, List<String>> mp = new HashMap<>();
        Arrays.sort(strs);
        for (String str : strs) {
            char[] s = str.toCharArray();
            Arrays.sort(s);
            String newStr = new String(s);
            if (!mp.containsKey(newStr.hashCode()))
                mp.put(newStr.hashCode(), new ArrayList<String>());
            mp.get(newStr.hashCode()).add(str);
        }
        return new ArrayList<List<String>>(mp.values());
    }
}
