import java.util.*;

public class Solution {
    public String largestNumber(int[] num) {
        StringBuilder res = new StringBuilder();
        if (num == null || num.length == 0){
            res.toString();
        } 
        String[] str = new String[num.length];
        for (int i = 0; i < num.length; i++){
            str[i] = num[i] + "";
        }
        Comparator<String> comp = new Comparator<String>(){
             public int compare(String s1, String s2){    //Do not use s1 and s2 here
                 return Long.compare(Long.valueOf(s2+s1), Long.valueOf(s1+s2));
             }  
        };
        Arrays.sort(str, comp);
        if (str[0].equals("0")) {
            return "0"; //why
        }
        for (String s:str){
            res.append(s);
        }
        return res.toString();
    }
}