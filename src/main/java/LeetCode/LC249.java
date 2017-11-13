package LeetCode;

/**
 * Created by jo0235 on 8/20/17.
 */
import java.util.*;
public class LC249 {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> m = new HashMap<>();
        for(int i=0;i<strings.length;i++){
            String code = encode(strings[i]);
            if(!m.containsKey(code))
                m.put(code,new ArrayList<>());
            m.get(code).add(strings[i]);
        }
        List<List<String>> rt = new ArrayList<>();
        rt.addAll(m.values());
        return rt;
    }
    public String encode(String s){
        if(s.length()==1)
            return " ";
        else{
            StringBuilder sb =new StringBuilder();
            for(int i=1;i<s.length();i++){
                int diff =s.charAt(i)-s.charAt(i-1);
                diff=diff<0?diff+26:diff;
                sb.append(String.valueOf(diff));
                sb.append("|");
            }
            return sb.toString();
        }
    }
    public static void main(String[] args){
        new LC249().groupStrings(new String[]{"abc","bcd","acef","xyz","az","ba","a","z","cd","xy"});
    }
}
