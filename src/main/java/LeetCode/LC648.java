package LeetCode;
import java.util.*;
public class LC648 {
    public static String replaceWords(List<String> dict, String sentence) {
        TrieNode root =new TrieNode();
        for(String word:dict)
            root.addWord(word);
        StringBuilder sb =new StringBuilder();
        String[] words =sentence.trim().split(" ");
        for(int i=0;i<words.length;i++){
            String word = words[i].trim();
            if(word.length()>0){
                String wordroot = root.searchRoot(word);
                if(wordroot==null)
                    sb.append(word);
                else
                    sb.append(wordroot);
                sb.append(" ");

            }
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    public static void main(String[] args){
//        replaceWords(Arrays.asList("a", "b", "c"),
//               "aadsfasf absbs bbab cadsfafs");
        replaceWords(Arrays.asList("cat", "bat", "rat"),
        "the cattle was rattled by the battery");
    }
}
