public class Solution {
    public String getHint(String secret, String guess) {
        int a=0,b=0;
        Map<Character, Integer> secretChars = new HashMap<Character, Integer>();
        for (char c:secret.toCharArray())
            secretChars.put(c, secretChars.get(c)==null?1:secretChars.get(c)+1);
        for (int i=0;i<guess.length();i++){
            char c = guess.charAt(i);
            Integer val = secretChars.get(c)==null?0:secretChars.get(c);
            if (c == secret.charAt(i)){
                a++;
                if (val<=0)
                    b--;
            }
            else if (val>0)
                b++;
            secretChars.put(c, val-1);
        }
        return a+"A"+b+"B";
    }
}