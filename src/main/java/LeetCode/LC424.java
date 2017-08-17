package LeetCode;
import java.util.*;
public class LC424 {
    public static int characterReplacement(String s, int k) {
        if(s.length()<=2) return s.length();
        int start=0;
        int end=0;
        Map<Character,Integer> m = new HashMap<>();
        int rt = Integer.MIN_VALUE;
        while(start<s.length()){
            start=expand(s,m,start,k);
            rt=Math.max(rt,start-end+1);
            if(start==s.length()-1) break;
            end =shrink(s,m,end,s.charAt(start+1));
            start++;
        }
        return rt;

    }
    public static int expand(String s,Map<Character,Integer> m,int start,int k){
        for(;start<s.length();start++){
            char c = s.charAt(start);
            boolean flag;
            if(k==0)
                flag = m.containsKey(c) || m.size()==0;
            else
                flag = m.containsKey(c) && m.get(c)<k || !m.containsKey(c);
            if(flag){
                if(m.containsKey(c))
                    m.put(c,m.get(c)+1);
                else
                    m.put(c,1);
            }
            else
                break;
        }
        return start-1;

    }
    public static int shrink(String s,Map<Character,Integer> m,int end,char c){
        boolean flag= true;
        while(flag){
            if(s.charAt(end)==c) flag =false;
            m.put(s.charAt(end),m.get(s.charAt(end))-1);
            end++;
        }
        return end;

    }
    public static void main(String[] args){

    }
}
