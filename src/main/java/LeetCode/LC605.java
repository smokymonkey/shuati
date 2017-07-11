package LeetCode;

/**
 * Created by jo0235 on 7/10/17.
 */
public class LC605 {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n==0) return true;

        int i =0;
        int tmp = n;
        while(tmp>0){
            while(i<flowerbed.length && flowerbed[i]==1)
                i++;
            if(i==flowerbed.length)
                break;
            int base=i-1;
            while(i<flowerbed.length && flowerbed[i]==0)
                i++;
            int space = i-base-1;
            int remove;
            if(base==-1 && i==flowerbed.length)
                remove =0;
            else if(base==-1 || i==flowerbed.length)
                remove =1;
            else
                remove =2;

            int t = space -remove;
            if(t>=0)
                tmp-=(t/2+t%2);


        }
        return tmp<=0;

    }
    public static void main(String[] args){
        boolean t =canPlaceFlowers(new int[]{0,1,0,1,0,1,0,0},1);
    }
}
