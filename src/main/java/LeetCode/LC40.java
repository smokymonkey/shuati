package LeetCode;

/**
 * Created by jo0235 on 8/22/17.
 */
import java.util.*;
public class LC40 {

    public List<List<Integer>> combinationSum2(int[] num, int target) {
        if (target<=0 || num.length==0) return new ArrayList<>();
        Arrays.sort(num);
        Map<Integer,List<List<Integer>>> m =new HashMap<>();
        return helper(num,target,0,m);
    }

    public List<List<Integer>> helper(int[] nums,int target,int index,Map<Integer,List<List<Integer>>> m){
        if(m.containsKey(target))
            return m.get(target);

        List<List<Integer>> rt = new ArrayList<>();
        if(nums[index]>target)
            return rt;
        if(nums[index]==target){
            rt.add(Arrays.asList(target));
            m.put(target,rt);
            return rt;
        }
        while(index<nums.length && nums[index]<target){
            List<List<Integer>> tmp = helper(nums,target-nums[index],index+1,m);
            for(List<Integer> l:tmp){
                List<Integer> t=new ArrayList<>(l);
                t.add(nums[index]);
                rt.add(t);
            }
            int currentNum=nums[index];
            while(index<nums.length && currentNum==nums[index])
                index++;
        }
        m.put(target,rt);
        return rt;
    }
    public static void main(String[] args){
        new LC40().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5},8);
    }
}
