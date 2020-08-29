import java.util.LinkedList;
import java.util.Queue;

public class MiniSum_907 {
    public int sumSubarrayMins(int[] A) {
        Queue<Helper> q = new LinkedList();
        int m = 1000000007;
        int rt = 0;
        for(int i =0;i<A.length;i++)
            q.add(new Helper(i,A[i]));
        while(q.size()>0){
            Helper h = q.remove();
            rt = (rt+h.val)%m;
            if(h.idx+1<A.length)
                q.add(new Helper(h.idx+1,Math.min(h.val,A[h.idx+1])));
        }
        return rt;

    }
    class Helper{
        public int idx;
        public int val;
        public Helper(int idx,int val){
            this.idx = idx;
            this.val = val;
        }
    }

    public static void main(String[] args){
        MiniSum_907 ms = new MiniSum_907();
        System.out.println(ms.sumSubarrayMins(new int[]{3,1,2,4}));
        System.out.println(ms.sumSubarrayMins(new int[]{3,1,2,4,9}));
    }
}
