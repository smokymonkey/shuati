package LeetCode;
import java.util.*;
public class LC336 {
    public static List<List<Integer>> palindromePairs(String[] words) {
        TrieNode root = new TrieNode();
        Map<String,Integer> reverseMap=new HashMap<>();
        List<List<Integer>> rt =new ArrayList<>();
        for(int i=0;i<words.length;i++){
            String reverseWord=new StringBuilder(words[i]).reverse().toString();
            root.addWord(reverseWord);
            reverseMap.put(reverseWord,i);
        }
        for(int i=0;i<words.length;i++){
            List<String> tmp = root.withPrefix(words[i]);
            if(tmp==null || tmp.isEmpty()) continue;
            for(String postFix :tmp){
                if(isPalindrome(words[i]+words[reverseMap.get(postFix)]))
                    rt.add(Arrays.asList(i,reverseMap.get(postFix)));
            }
        }
        return rt;
    }
    static boolean isPalindrome(String s ){
        for(int i=0,j=s.length()-1;i<j;i++,j--)
            if(s.charAt(i)!=s.charAt(j))
                return false;
        return true;
    }
    public static void main(String[] args){
        palindromePairs(new String[]{"abcd","dcba","lls","s","sssll"});
    }
}
