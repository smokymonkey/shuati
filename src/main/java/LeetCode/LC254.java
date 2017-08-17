package LeetCode;
import java.util.*;
public class LC254 {
    public static List<List<Integer>> getFactors(int n) {
        List<List<Integer>> rt =new ArrayList<>();
        int count=0;
        List<List<Integer>> tmp = helper(n,2);
        count = tmp.size();
        rt.addAll(tmp);
        while(count>0){
            int startIdx= rt.size()-count;
            int endIdx=rt.size()-1;
            count=0;
            for(int i=startIdx;i<=endIdx;i++){
                List<Integer> prevList = rt.get(i);
                int largest = prevList.get(prevList.size()-1);
                int secondLargest = prevList.get(prevList.size()-2);
                tmp=helper(largest,secondLargest);
                if(!tmp.isEmpty()){
                    count+=tmp.size();
                    for(List<Integer> l: tmp){
                        List<Integer> newList =new ArrayList<>(prevList);
                        newList.remove(newList.size()-1);
                        newList.addAll(l);
                        rt.add(newList);
                    }
                }

            }
        }
        return rt;
    }
    public static List<List<Integer>> helper(int n, int lowerbound){
        List<List<Integer>> rt =new ArrayList<>();
        for (int i=lowerbound;i<=(int)Math.sqrt(n);i++){
            if(n%i==0){
                rt.add(Arrays.asList(i,n/i));
            }

        }
        return rt;
    }
    public static void main(String[] args){
        getFactors(12);
    }
}
