public class Solution {
    public List<String> anagrams(String[] strs) {
        // basic idea: HashMap <Sting, ArrayList<String>> + sort String
        // time: O(n * time to sort the string)
        // space: O(n)
        List<String> rst = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return rst;
        }
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<String>());
            }
            map.get(sorted).add(strs[i]);
        }
        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
                for (String s : map.get(key)) {
                    rst.add(s);
                }
            }
        }
        return rst;
    }
}