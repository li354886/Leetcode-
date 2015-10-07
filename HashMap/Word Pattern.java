public class Solution {
    public boolean wordPattern(String pattern, String str) {
            String[] arr = str.split(" ");
            char[] patternarr = pattern.toCharArray();
            if(arr.length!= patternarr.length)
                return false;
            HashMap<Character, String> h = new HashMap<Character, String>();
            for(int i=0;i<patternarr.length;i++)
            {
                char c = patternarr[i];
                String temp = arr[i];
                if(!h.containsKey(c))
                {
                    if(h.containsValue(temp))
                        return false;
                    else
                        h.put(c,temp);
                }
                else
                {
                    if(h.get(c).equals(temp))
                        continue;
                    else
                        return false;
                }
            }
            return true;  
    }
}