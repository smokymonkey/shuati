package LeetCode;
import java.util.*;
public class LC254 {
    public static List<List<Integer>> getFactors(int n) {
        List<List<Integer>> rt = new ArrayList<>();
        if(n==1) return rt;
        int tobefactor = n;
        int[] tmp;

        while((tmp=factor(tobefactor))!=null){
            if(rt.size()==0)
                rt.add(Arrays.asList(tmp[0],tmp[1]));
            else{
                List<Integer> l = new ArrayList<>(rt.get(rt.size()-1));
                l.set(l.size()-1,tmp[0]);
                l.add(tmp[1]);
                rt.add(l);
            }
            if(tmp[0]==tmp[1])
                break;
            if(rt.size()!=0)
                tobefactor=getLast(rt.get(rt.size()-1));
        }
        return rt;
    }
    public static int[] factor(int n){
        int sqrt = (int)Math.sqrt(n);
        for(int i=2;i<=sqrt;i++){
            if(n%i==0){
                return new int[]{i,n/i};
            }
        }
        return null;
    }
    public static int getLast(List<Integer> l){
        if(l.size()==0)
            return 0;
        else
            return l.get(l.size()-1);
    }
    public static void main(String[] args){
        getFactors(12);
    }
}
