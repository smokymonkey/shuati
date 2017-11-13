package LeetCode;

/**
 * Created by jo0235 on 8/18/17.
 */
import java.util.*;
public class LC261 {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length<=1) return true;
        Map<Integer,Integer> neighborCount= new HashMap<>();
        Map<Integer,Set<Integer>> neighbors =new HashMap<>();
        for(int i=0;i<edges.length;i++){
            int p1= edges[i][0];
            int p2= edges[i][1];
            if(neighborCount.containsKey(p1))
                neighborCount.put(p1,neighborCount.get(p1)+1);
            else
                neighborCount.put(p1,1);
            if(neighborCount.containsKey(p2))
                neighborCount.put(p2,neighborCount.get(p2)+1);
            else
                neighborCount.put(p2,1);
            if(!neighbors.containsKey(p1))
                neighbors.put(p1,new HashSet<>());
            neighbors.get(p1).add(p2);
            if(!neighbors.containsKey(p2))
                neighbors.put(p2,new HashSet<>());
            neighbors.get(p2).add(p1);
        }
        if(neighborCount.size()!=n) return false;
        Queue<Integer> q = new LinkedList<>();
        for(Integer p : neighborCount.keySet())
            if(neighborCount.get(p)==1){
                q.offer(p);
            }
        while(!q.isEmpty()){
            int p=q.poll();
            // Set<Integer> neighbor==neighbors.get(p);
            for(Integer i: neighbors.get(p)){
                neighbors.get(i).remove(p);
                neighborCount.put(i,neighborCount.get(i)-1);
                if(neighborCount.get(i)==1)
                    q.offer(i);
            }
            neighborCount.remove(p);

        }
        return neighborCount.size()<=2;

    }
    public static void main(String[] args){
        new LC261().validTree(5,new int[][]{{0,1},{0,2},{2,3},{2,4}});
    }
}
