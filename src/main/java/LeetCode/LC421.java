package LeetCode;
import java.util.*;
public class LC421 {
    public static int findMaximumXOR(int[] nums) {
        Set<Integer> s = new HashSet<>();
        int b = 0b11000000000000000000000000000000;
        int c = 0b10000000000000000000000000000000;
        int rt =0;
        int d=0b01000000000000000000000000000000;
        for(int i=0;i<31;i++){
            if(i>0)
                b>>=1;
            int a = c^b;

            s.clear();
            for(int j=0;j<nums.length;j++){
                s.add(nums[j]&a);
            }
            for(int j=0;j<nums.length;j++){
                if(s.contains((nums[j]^a)&a)){
                    rt|=d;
                    break;
                }
            }
            d>>=1;
        }
        return rt;
    }
    public static void main(String[] args) {
        findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8});
    }
}
