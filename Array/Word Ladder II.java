public class Solution {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        Queue<String> word = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        word.add(start);
        map.put(start, 1);
        
        int minDepth = Integer.MAX_VALUE;
        while (!word.isEmpty()) {
            String currWord = word.poll();
            int currDepth = map.get(currWord);
            if (currDepth >= minDepth) {
                continue;
            }
            if (currWord.equals(end)) {
                minDepth = Math.min(minDepth, currDepth);
                continue;
            }
            for (int i = 0; i < currWord.length(); i++) {
                char[] currWordArr = currWord.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    currWordArr[i] = c;
                    String newWord = new String(currWordArr);
                    if (dict.contains(newWord) && !map.containsKey(newWord)) {
                        word.add(newWord);
                        map.put(newWord, currDepth + 1);
                    }
                }
            }
        }
        List<List<String>> pathSet = new ArrayList<List<String>>();
        List<String> path = new ArrayList<>();
        path.add(start);
        dfs(start, end, map, path, pathSet);
        return pathSet;
    }
    
    private void dfs(String start, String end, Map<String, Integer> map, List<String> path, List<List<String>> pathSet) {
        if (start.equals(end)) {
            pathSet.add(new ArrayList<String>(path));
            return;
        }
        int currDepth = map.get(start);
        for (int i = 0; i < start.length(); i++) {
            char[] currWordArr = start.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                currWordArr[i] = c;
                String newWord = new String(currWordArr);
                if (map.containsKey(newWord) && map.get(newWord) == currDepth + 1) {
                   // int size = path.size();
                    path.add(newWord);
                    dfs(newWord, end, map, path, pathSet);
                    path.remove(path.size() - 1);
                }
            }
        }
    }
}