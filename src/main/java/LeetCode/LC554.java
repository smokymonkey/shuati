package LeetCode;
import java.util.*;
public class LC554 {
    public static int leastBricks(List<List<Integer>> wall) {
        PriorityQueue<Position> pq = new PriorityQueue<Position>((a,b)->a.sum-b.sum);
        Map<Integer,Integer> m  =new HashMap<>();
        for(int i=0;i<wall.size();i++){
            int width = wall.get(i).get(0);
            pq.offer(new Position(i,0,width));
            addToMap(m,width);
        }
        int rt =wall.size()-m.get(pq.peek().sum);
        while(!pq.isEmpty()){
            int smallestsum = pq.peek().sum;
            while(!pq.isEmpty()&&pq.peek().sum==smallestsum) {
                Position p = pq.poll();
                if (p.index == wall.get(p.row).size() - 1)
                    continue;
                else {
                    int tmp = p.sum + wall.get(p.row).get(p.index + 1);
                    removeFromMap(m, p.sum);
                    addToMap(m, tmp);
                    pq.offer(new Position(p.row, p.index + 1, tmp));

                }
            }
            if(pq.peek().index!=wall.get(pq.peek().row).size()-1)
                rt = Math.min(rt, wall.size() - m.get(pq.peek().sum));

        }
        return rt;


    }
    public static void addToMap(Map<Integer,Integer> m,int i){
        if(m.containsKey(i))
            m.put(i,m.get(i)+1);
        else
            m.put(i,1);
    }
    public static void removeFromMap(Map<Integer,Integer> m,int i){
        if(m.containsKey(i)){
            m.put(i,m.get(i)-1);
        }

    }
    public static void main(String[] args){
        leastBricks(Arrays.asList(Arrays.asList(1,2,2,1),Arrays.asList(3,1,2),Arrays.asList(1,3,2),Arrays.asList(2,4),Arrays.asList(3,1,2),Arrays.asList(1,3,1,1)));
    }
}
class Position{
    int row;
    int index;
    int sum;
    public Position(int _row,int _index,int _sum){
        row=_row;
        index = _index;
        sum=_sum;
    }
}