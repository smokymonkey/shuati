package LeetCode;
import java.util.*;
/**
 * Created by jie on 7/9/17.
 */
public class LC438 {

    public static List<Integer> findAnagrams(String s, String p) {
        Map<Character,Integer> m = new HashMap<>();
        for(int i=0;i<p.length();i++){
            if(m.containsKey(p.charAt(i)))
                m.put(p.charAt(i),m.get(p.charAt(i))+1);
            else
                m.put(p.charAt(i),1);
        }
        int count=0;
        List<Integer> rt = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(i>=p.length()) {
                char c = s.charAt(i - p.length());
                if (m.containsKey(c)) {
                    m.put(c, m.get(c) + 1);
                    if (m.get(c) == 0)
                        count++;
                    if (m.get(c) == 1)
                        count--;
                }
            }
            char c=s.charAt(i);
            if(m.containsKey(c)){
                m.put(c,m.get(c)-1);
                if (m.get(c)==0)
                    count++;
                if(m.get(c)==-1)
                    count--;
            }
            if(count==m.size())
                rt.add(i-p.length()+1);


        }
        return rt;
    }
    public static void  main(String[] args) {
        List<Integer> r=findAnagrams("bbbababaaabbb","ba");
    }
}


