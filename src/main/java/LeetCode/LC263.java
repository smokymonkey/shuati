package LeetCode;

/**
 * Created by jie on 7/9/17.
 */
public class LC263 {
    public static boolean isUgly(int num) {
        if(num==1) return true;
        long tmp;
        if(num<0)
            tmp=(-1*(long)num);
        else
            tmp =num;
        while(tmp>1){
            if(tmp%2==0)
                tmp=tmp/2;
            else if(tmp%3==0)
                tmp=tmp/3;
            else if(tmp%5==0)
                tmp=tmp/5;
            else
                return false;
        }
        return true;
    }
    public static void main(String[] args){
        boolean r=isUgly(-2147483648);
    }
}
