package LeetCode;

/**
 * Created by jie on 7/22/17.
 */
import java.util.*;
public class LC524 {
    public static String findLongestWord(String s, List<String> d) {
        Collections.sort(d);
        int[] count = new int[26];
        for(int i=0;i<s.length();i++)
            count[s.charAt(i)-'a']+=1;
        String rt = "";
        for(int i =d.size()-1;i>=0;i--){
            String word = d.get(i);
            if(word.length()<rt.length())
                return rt;
            int[] tmp =new int[26];
            int j=0;
            for(j=0;j<word.length();j++){
                tmp[word.charAt(j)-'a']+=1;
                if(tmp[word.charAt(j)-'a']>count[word.charAt(j)-'a'])
                    break;
            }
            if(j==word.length())
                rt = word;

        }
        return rt;
    }
    public static  void main(String[] args){
        findLongestWord("bab",Arrays.asList("ba","ab","a","b"));
    }

}
