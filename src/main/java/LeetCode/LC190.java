package LeetCode;

/**
 * Created by jie on 7/15/17.
 */
public class LC190 {
    public static int reverseBits(int n) {
        int rt=n&1;
        for(int i=1;i<32;i++){
            rt<<=1;
            n>>>=1;
            rt=rt|(n&1);
        }
        return rt;
    }
    public static void main(String[] args){
        reverseBits(43261596);
    }
}
