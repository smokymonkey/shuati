package LeetCode;
import java.util.*;
public class LC336 {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> rt = new ArrayList<>();
        for(int i=0;i<words.length-1;i++)
            for(int j=i+1;j<words.length;j++){
                int smaller = words[i].length()>words[j].length()?j:i;
                int bigger = words[i].length()<=words[j].length()?j:i;
                if(words[smaller].length()==words[bigger].length()) {
                    if (reverseEqual(words[smaller], words[bigger])) {
                        rt.add(Arrays.asList(smaller, bigger));
                        rt.add(Arrays.asList(bigger, smaller));
                    }
                }
                else{
                    if(isReversePrefix(words[smaller],words[bigger]) && isPalindrome(words[bigger],words[smaller].length(),words[bigger].length()-1))
                        rt.add(Arrays.asList(bigger,smaller));
                    if(isReversePostfix(words[smaller],words[bigger]) && isPalindrome(words[bigger],0,words[bigger].length()-1-words[smaller].length()))
                        rt.add(Arrays.asList(smaller,bigger));
                }
            }
        return rt;
    }

    public boolean reverseEqual(String s1,String s2){
        if (s1.length()!=s2.length()) return false;
        int i =0,j=s2.length()-1;
        while(j>=0){
            if(s1.charAt(i)!=s2.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    public boolean isReversePrefix(String smaller, String bigger){
        for(int i=0;i<smaller.length();i++){
            if(smaller.charAt(i)!=bigger.charAt(smaller.length()-1-i))
                return false;
        }
        return true;

    }
    public boolean isReversePostfix(String smaller,String bigger){
        for(int i=0;i<smaller.length();i++){
            if(smaller.charAt(i)!=bigger.charAt(bigger.length()-1-i))
                return false;
        }
        return true;
    }
    public boolean isPalindrome(String word, int start, int end){
        while(start<end){
            if(word.charAt(start)!=word.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;

    }
    public static void main(String[] args){
        new LC336().palindromePairs(new String[]{"abcd","dcba","lls","s","sssll"});
    }
}
