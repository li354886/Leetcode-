public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<String> list = new ArrayList<>();
        int strLen = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < words.length; i++) {
            if (strLen == 0 || strLen + words[i].length() + 1 <= L) {
                if (strLen > 0) {
                    strLen += 1;
                }
                end = i;
                strLen += words[i].length();
            } else {
                list.add(formLine(words, start, end, strLen, L));
                strLen = words[i].length();
                start = i;
                end = i;
            }
        }
        list.add(formLine(words, start, end, strLen, L));
        return list;
    }
    
    private String formLine(String[] words, int start, int end, int strLen, int L) {
        int N = end - start;
        int M = L - strLen;
        StringBuilder str = new StringBuilder();
        if (N == 0 || end == words.length - 1) {
            for (int i = start; i <= end; i++) {
                if (i > start) {
                    str.append(" ");
                }
                str.append(words[i]);
            }
            for (int i = 0; i < M; i++) {
                str.append(" ");
            }
        } else {
            for (int i = start; i <= end; i++) {
                if (i == start) {
                    str.append(words[i]);
                } else {
                    for (int j = 0; j < 1+ M / N; j++) {
                        str.append(" ");
                    }
                    if (i <= start + M % N) {
                        str.append(" ");
                    }
                    str.append(words[i]);
                }
            }
        }
        return str.toString();
    }
}