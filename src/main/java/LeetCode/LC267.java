package LeetCode;

/**
 * Created by jo0235 on 8/18/17.
 */
import java.util.*;
public class LC267 {
    public List<String> generatePalindromes(String s) {
        //s.length==1
        Map<Character,Integer> m=new HashMap<>();
        int oddCount=0;
        char oddChar='\0';
        if(s.length()==1)
            return Arrays.asList(s);
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (m.containsKey(c))
                m.put(c, m.get(c) + 1);
            else
                m.put(c, 1);
        }
        for(Character key:m.keySet()) {
            if(m.get(key)%2!=0) {
                oddCount++;
                oddChar=key;
            }

        }


        if(oddCount>1) return new ArrayList<>();
        else{
            if(oddChar!='\0') {
                if (m.get(oddChar) == 1)
                    m.remove(oddChar);
                else
                    m.put(oddChar,m.get(oddChar)-1);
            }
            List<String> rt = helper(m);
            for(int i=0;i<rt.size();i++){
                StringBuilder sb = new StringBuilder(rt.get(i));
                if(oddChar=='\0')
                    rt.set(i,rt.get(i)+sb.reverse().toString());
                else
                    rt.set(i,rt.get(i)+oddChar+sb.reverse().toString());
            }
            return rt;

        }

    }
    List<String> helper(Map<Character,Integer> m){
        if(m.size()==1){
            StringBuilder sb= new StringBuilder();
            for(Character c:m.keySet()){
                for(int i=0;i<m.get(c);i+=2){
                    sb.append(c);
                }
            }
            return Arrays.asList(sb.toString());
        }else{
            List<String> rt =new ArrayList<>();
            Set<Character> s =new HashSet<>(m.keySet());
            for(Character c:s){
                m.put(c,m.get(c)-2);
                if(m.get(c)==0){
                    m.remove(c);
                }
                List<String> tmp = helper(m);
                for(String postFix:tmp)
                    rt.add(c+postFix);
                if(m.containsKey(c))
                    m.put(c,m.get(c)+2);
                else
                    m.put(c,2);

            }
            return rt;
        }
    }
    public static void main(String[] args){
        new LC267().generatePalindromes("ivicc");
    }
}
