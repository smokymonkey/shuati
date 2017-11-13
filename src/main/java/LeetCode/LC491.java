package LeetCode;
import java.util.*;
public class LC491 {
    public static List<List<Integer>> findSubsequences(int[] nums) {
        List[] m = new List[nums.length];
        List<List<Integer>> rt =new ArrayList<>();
        if(nums.length<=1) return  rt;
        m[nums.length-1]=new ArrayList<>();
        for(int i=nums.length-2;i>=0;i--){
            Set<Integer> visited =new HashSet<>();
            m[i]=new ArrayList<List<Integer>>();
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]<=nums[j] && !visited.contains(nums[j])){
                    m[i].add(new LinkedList<>(Arrays.asList(nums[i],nums[j])));
                    for(int k=0;k<m[j].size();k++){
                        List<Integer> tmp =new LinkedList<>((List<Integer>)m[j].get(k));
                        tmp.add(0,nums[i]);
                        m[i].add(tmp);
                    }
                }
                visited.add(nums[j]);
            }
            rt.addAll(m[i]);
        }
        return rt;

    }
    public static void main(String[] args){
        findSubsequences(new int[]{4,6,7,7});
    }

}
