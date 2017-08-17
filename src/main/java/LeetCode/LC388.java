package LeetCode;
import java.util.*;

/**
 * Created by jie on 7/13/17.
 */
public class LC388 {
    public static int lengthLongestPath(String input) {
//        Stack<Integer> segLength= new Stack<>();
//        int nt =0;
//        int count=0;
//        int rt =0;
//        boolean findfile=false;
//        for(int i=0;i<input.length();i++){
//            char c = input.charAt(i);
//            if(c=='\n'){
//                if(nt==0){
//                    segLength.push(count);
//                }else{
//                    while(segLength.size()>nt)
//                        segLength.pop();
//                    int top=segLength.peek();
//                    segLength.push(top+1+count);
//                    if(findfile){
//                        rt=Math.max(rt,segLength.peek());
//                        findfile=false;
//
//                    }
//                }
//                nt=0;
//                count=0;
//
//            }
//            else if(c=='\t' ){
//                nt++;
//            }else {
//                count++;
//                if (c == '.')
//                    findfile = true;
//            }
//
//        }
//        if(nt==0){
//            segLength.push(count);
//        }else{
//            segLength.push(segLength.peek()+1+count);
//        }
//        rt=Math.max(rt,segLength.peek());
//        return rt;

        Stack<Integer> segLength= new Stack<>();
        int nt =0;
        int count=0;
        int rt =0;
        boolean findfile=false;
        for(int i=0;i<input.length();i++){
            char c = input.charAt(i);
            if(c=='\n' ){
                if(nt==0){
                    segLength.push(count);
                }else{
                    while(segLength.size()>nt)
                        segLength.pop();
                    int top=segLength.peek();
                    segLength.push(top+1+count);
                    if(findfile){
                        rt=Math.max(rt,segLength.peek());
                        findfile=false;

                    }
                }
                nt=0;
                count=0;

            }
            else if(c=='\t' ){
                nt++;
            }else{
                count++;
                if(c=='.')
                    findfile=true;
            }

        }
        if(nt==0){
            segLength.push(count);
        }else{
            segLength.push(segLength.peek()+1+count);
        }
        rt=Math.max(rt,segLength.peek());
        return rt;
    }
    public static void main(String[] args){
        lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext");
//        lengthLongestPath("dir.ext");
    }
}
