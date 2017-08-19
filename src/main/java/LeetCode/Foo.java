package LeetCode;

/**
 * Created by jo0235 on 8/7/17.
 */
import java.util.*;
public class Foo {
    private Map<Character,List<Character>> mapping;
    public Foo(){
        mapping=new HashMap<>();
        mapping.put('2',Arrays.asList('a','b','c'));
        mapping.put('3',Arrays.asList('d','e','f'));
        mapping.put('1',new ArrayList<>());
        mapping.put('0',new ArrayList<>());

    }
    public List<String> getAllPossibleStrings(String s){
        if(s==null || s.length()==0) return new ArrayList<>();
        List<String> rt = new ArrayList<>();
        rt.add("");
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)<'0'||s.charAt(i)>'9')
                throw new RuntimeException("invalid character in input");
            List<String> tmp =new ArrayList<>();
            for(String prefix:rt){
                for(Character c: mapping.get(s.charAt(i)))
                    tmp.add(prefix+c);
            }
            rt=tmp;
        }
        return rt;
    }
    public List<String> getAllWords(String s){
        if(s==null || s.length()==0) return new ArrayList<>();
        List<String> allPossibleWords = getAllPossibleStrings(s);
        List<String> words = new ArrayList<>();
        for(String possibleWord:allPossibleWords){
            //if(is_word(possibleWord))
            //    words.add(possibleWord);
        }
        return words;
    }
    public static void main(String[] args){
        List<String> words = new Foo().getAllPossibleStrings("2302");
        for(String word:words)
            System.out.println(word);
    }
}
