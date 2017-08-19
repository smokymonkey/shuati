package LeetCode;

/**
 * Created by jo0235 on 7/12/17.
 */
public class LC151 {
    public static String reverseWords(String s) {

        s=s.trim();
        StringBuilder sb =new StringBuilder();
        int startIdx=0;
        int endIdx;
        while(startIdx<s.length()){
            while(startIdx<s.length() && s.charAt(startIdx)==' ' )
                startIdx++;
            endIdx=startIdx;
            while(endIdx<s.length() && s.charAt(endIdx)!=' ')
                endIdx++;
            if(startIdx<s.length()){
                sb.insert(0,s.substring(startIdx,endIdx));
                sb.insert(0," ");
            }
            startIdx=endIdx;

        }
        sb.delete(0,1);
        return sb.toString();
    }
    public static void reverse(StringBuilder sb){
        int startIdx = 0;
        int endIdx=sb.length()-1;
        while(startIdx<endIdx){
            char tmp = sb.charAt(startIdx);
            sb.setCharAt(startIdx,sb.charAt(endIdx));
            sb.setCharAt(endIdx,tmp);
            startIdx++;
            endIdx--;
        }
    }
    public static void main(String[] args){
        String s=reverseWords(" ab  cd ");
        System.out.println(s);
    }
}
