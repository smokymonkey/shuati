package LeetCode;

/**
 * Created by jie on 7/16/17.
 */
public class LC172 {
    public static int trailingZeroes(int n) {
//        int nfive=0;
//        int five=5;
//        while(five<=n){
//            nfive +=(n/five);
//            five *=5;
//        }
//        return nfive;
        int r = 0;
        while (n > 0) {
            n /= 5;
            r += n;
        }
        return r;
//        int count = 0;
//
//        // Keep dividing n by powers of 5 and update count
//        for (int i=5; n/i>=1; i *= 5)
//            count += n/i;
//
//        return count;
    }
    public static void main(String[] args){
        trailingZeroes(1808548329);
    }
}
