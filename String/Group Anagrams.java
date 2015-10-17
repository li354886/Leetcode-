public class Solution {
    public List<String> anagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> tmp;
        for (String str : strs) {
            //map.put(str, new ArrayList<String>);
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            if (!map.containsKey(key)) {
                //tmp = map.get(key);
                tmp = new ArrayList<String>();
                tmp.add(str);
                map.put(key, tmp);
            } else {
                map.get(key).add(str);
            }
        }
        for (String s : map.keySet()) {
            if (map.get(s).size() > 1) {
                for (String string : map.get(s)) {
                    result.add(string);
                }
            }
        }
        
        
        return result;
    }
}