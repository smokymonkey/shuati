package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jie on 5/26/17.
 */
public class LC149 {
    public int solution1(Point[] points) {
        Map<Double,Integer> count = new HashMap<>();
        int rt=0;
        int samepoint=0;
        if(points.length<=2) return points.length;
        for (int i=0;i<points.length-1;i++){
            count.clear();
            samepoint=1;
            if (points[i]==null)
                continue;
            for(int j=i+1;j<points.length;j++){
                if (points[j]!=null){
                    if((points[j].x==points[i].x) && (points[j].y==points[i].y)){
                        samepoint++;
                        points[j]=null;
                    }
                    else{
                        Double slop;
                        if (points[i].x==points[j].x)
                            slop=Double.NaN;
                        else if(points[i].y==points[j].y) {
                            slop = 0d;
                        }else{
                            slop = (double) (points[i].y - points[j].y) / (points[i].x - points[j].x);
                        }
                        if(!count.containsKey(slop))
                            count.put(slop,1);
                        else
                            count.put(slop,count.get(slop)+1);
                    }
                }
            }

            if(!count.isEmpty()) {
                for (Double d : count.keySet()) {
                    int tmp = count.get(d) + samepoint;
                    rt = rt < tmp ? tmp : rt;
                }
            }else
                rt=rt<samepoint?samepoint:rt;
        }
        return rt;
    }

}
