package LeetCode;
import java.util.*;
public class TrieNode {
    TrieNode[] children;
    boolean[] isWord;
    public TrieNode(){
        children = new TrieNode[26];
        isWord = new boolean[26];
    }
    public boolean isWord(String word){
        return isWord(word,0);
    }
    private boolean isWord(String word, int index){
        if(index==word.length()-1)
            return isWord[word.charAt(index)-'a'];
        else {
            TrieNode child = getChild(word.charAt(index));
            if ( child == null)
                return false;
            else
                return child.isWord(word,index+1 );
        }
    }
    public void addWord(String word){
        addWord(word,0);
    }
    private void addWord(String word, int index ){
        if(index==word.length()-1)
            isWord[word.charAt(index)-'a']=true;
        else{
            TrieNode child=addChild(word.charAt(index));
            child.addWord(word,index+1);
        }

    }
    public TrieNode addChild(char c){
        if(children[c-'a']==null)
            children[c-'a']=new TrieNode();
        return getChild(c);
    }
    public TrieNode getChild(char c){
        return children[c-'a'];
    }
    public String searchRoot(String word){
        return searchRoot(word,0,"");
    }
    private String searchRoot(String word, int index,String prefix){
        if(index==word.length())
            return null;
        if(isWord[word.charAt(index)-'a'])
            return prefix+word.charAt(index);
        TrieNode child = getChild(word.charAt(index));
        if(child==null)
            return null;
        else
            return child.searchRoot(word,index+1,prefix+word.charAt(index));
    }
    public List<String> withPrefix(String prefix){
        List<String> rt = new ArrayList<>();
        withPrefix(prefix,0,rt);
        return rt;
    }
    private void withPrefix(String prefix,int index,List<String> rt){

        if(index==prefix.length()-1){
            if(isWord[prefix.charAt(index)-'a'])
                rt.add(prefix);
            TrieNode child = getChild(prefix.charAt(index));
            if(child!=null)
                child.getAllWordUnder(rt,prefix);

        }else{
            TrieNode child = getChild(prefix.charAt(index));
            if(child!=null)
                child.withPrefix(prefix,index+1,rt);
        }

    }
    private void getAllWordUnder(List<String> words,String prefix){
        for(int i=0;i<26;i++)
            if(isWord[i])
                words.add(prefix+(char)(i+'a'));
        for(int i=0;i<26;i++){
            TrieNode child = children[i];
            if(child!=null)
                child.getAllWordUnder(words,prefix+(char)(i+'a'));
        }

    }
}
