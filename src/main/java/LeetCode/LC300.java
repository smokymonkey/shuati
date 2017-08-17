package LeetCode;

/**
 * Created by jie on 7/15/17.
 */
public class LC300 {
    public static int lengthOfLIS(int[] nums) {

        if(nums.length==0) return 0;
        int[] m = new int[nums.length];

        m[0]=1;
        for(int i=1;i<nums.length;i++){
            int tmp=1;
            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[i]){
                    tmp = Math.max(tmp,m[j]+1);
                }
            }
            m[i]=tmp;

        }
        return m[nums.length-1];

    }
    public static void main(String[] args){
//        lengthOfLIS(new int[]{1,2,3});
        lengthOfLIS(new int[]{4,10,4,3,8,9});
    }
}
