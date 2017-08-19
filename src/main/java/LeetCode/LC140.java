package LeetCode;

/**
 * Created by jo0235 on 7/13/17.
 */
import java.util.*;
public class LC140 {
    public static List<String> wordBreak(String s, List<String> _wordDict) {
        Set<String> wordDict = new HashSet<>();
        List[] m = new List[s.length()];
        Set<Integer> wordLengths= new HashSet<>();
        for(String word:_wordDict){
            wordLengths.add(word.length());
            wordDict.add(word);
        }
        for(int i =0;i<s.length();i++){
            int stringLength=i+1;
            for(Integer wordLength:wordLengths){
                if(stringLength>wordLength){
                    String lastWord=s.substring(i-wordLength+1,i+1);
                    if(wordDict.contains(lastWord)){
                        if(m[i]==null)
                            m[i]=new ArrayList<String>();
                        if(m[i-wordLength]!=null){
                            for(String prefix:(List<String>)m[i-wordLength])
                                m[i].add(prefix+" "+lastWord);
                        }
                    }
                }
            }
        }
        return (List<String>)m[s.length()-1];
    }
    public static void main(String[] args){
        wordBreak("catsanddog",Arrays.asList("cat","cats","and","sand","dog"));
    }
}
