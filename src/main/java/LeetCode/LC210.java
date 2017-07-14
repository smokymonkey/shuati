package LeetCode;
import java.util.*;
/**
 * Created by jo0235 on 7/13/17.
 */
public class LC210 {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,Integer> preq=new HashMap<>();
        Map<Integer,Set<Integer>> depend=new HashMap<>();
        for(int i =0;i<prerequisites.length;i++){
            int prerequisit = prerequisites[i][1];
            int dep =prerequisites[i][0];
            if(!depend.containsKey(dep))
                depend.put(dep,new HashSet<>());
            depend.get(dep).add(prerequisit);
            if(!preq.containsKey(prerequisit))
                preq.put(prerequisit,1);
            else
                preq.put(prerequisit,preq.get(prerequisit)+1);
        }
        List<Integer> rt = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(!preq.containsKey(i))
                q.offer(i);
        }
        while(!q.isEmpty()){
            int course = q.poll();
            rt.add(course);
            if(depend.containsKey(course)){
                for(Integer d:depend.get(course)){
                    preq.put(d,preq.get(d)-1);
                    if(preq.get(d)==0){
                        preq.remove(d);
                        q.offer(d);
                    }
                }
            }
        }
        if(preq.isEmpty()){
            int[] result = new int[rt.size()];
            for(int i =0;i<result.length;i++)
                result[i]=rt.get(result.length-i-1);
            return result;

        }else{
            return new int[0];
        }

    }
    public static void main(String[] args){
        findOrder(4,new int[][]{{1,0},{2,0},{3,1},{3,2}});
    }
}
