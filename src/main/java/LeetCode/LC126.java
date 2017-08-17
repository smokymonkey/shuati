package LeetCode;
import java.util.*;
public class LC126 {
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<Integer,Set<Integer>> m =new HashMap<>();
        wordList.add(beginWord);
        int startIdx =-1;
        int endIdx =-1;
        for(int i =0;i<wordList.size();i++){
            if(beginWord.equals(wordList.get(i)))
                startIdx = i;
            if(endWord.equals(wordList.get(i)))
                endIdx=i;
            for(int j =i+1;j<wordList.size();j++){
                if(diffByOne(wordList.get(i),wordList.get(j))){
                    if(!m.containsKey(i))
                        m.put(i,new HashSet<>());
                    m.get(i).add(j);
                    if(!m.containsKey(j))
                        m.put(j,new HashSet<>());
                    m.get(j).add(i);
                }
            }
        }

        List<List<String>> rt =new ArrayList<>();
        if(startIdx==-1 || endIdx==-1) return rt;

        Set<Integer> visited=new HashSet<>();
        Queue<List<Integer>> q = new LinkedList<>();
        q.offer(Arrays.asList(startIdx));
        q.offer(null);
        boolean found=false;
        while(!q.isEmpty()){
            List<Integer> l = q.poll();
            if (l==null)
                if(found)
                    break;
                else{
                    if(!q.isEmpty()) q.offer(null);
                    continue;
                }
            visited.add(l.get(l.size()-1));
            if(m.get(l.get(l.size()-1)).contains(endIdx)){
                List<String> tmp =new ArrayList<>();
                for(Integer i:l)
                    tmp.add(wordList.get(i));
                tmp.add(endWord);
                found=true;
                rt.add(tmp);
            }else{
                for(Integer i:m.get(l.get(l.size()-1)))
                    if(!visited.contains(i)){
                        List<Integer> tmp = new ArrayList<>(l);
                        tmp.add(i);
                        q.offer(tmp);
                    }
            }

        }
        return rt;


    }
    public static boolean diffByOne(String s, String t){
        int diff=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=t.charAt(i)){
                diff++;
                if(diff>1)
                    return false;
            }

        }
        return true;
    }
    public static void main(String[] args){
        List<String> l =new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        findLadders("hit","cog",l)   ;
    }
}
