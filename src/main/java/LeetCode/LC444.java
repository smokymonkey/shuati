package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.*;
public class LC444 {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Set<Integer> seeds = new HashSet<>();
        for(List<Integer> l:seqs){
            seeds.add(l.get(l.size()-1));
        }
        Map<Integer,Set<Integer>> after=new HashMap<>(); //key: number, value: how many after this number
        Map<Integer,Set<Integer>> before=new HashMap<>(); // key:number, value: numbers before this number
        for(List<Integer> l:seqs){
            for(int i=0;i<l.size()-1;i++){
                int a1=l.get(i);
                seeds.remove(a1);
                for(int j=i+1;j<l.size();j++){
                    int a2=l.get(j);
                    if(!after.containsKey(a1))
                        after.put(a1,new HashSet<>());
                    after.get(a1).add(a2);
                    if(!before.containsKey(a2))
                        before.put(a2,new HashSet<>());
                    before.get(a2).add(a1);
                }
            }
        }
        int idx=org.length-1;
        Queue<Integer> q = new LinkedList<>(seeds);
        while(q.size()==1 && idx>=0 && q.peek()==org[idx]){
            int seed =q.poll();
            if(idx>0){
                for(Integer i:before.get(seed)){
                    after.get(i).remove(seed);
                    if(after.get(i).size()==0){
                        q.offer(i);
                        after.remove(i);
                    }

                }
            }
            idx--;
        }
        if(idx<0 && after.isEmpty()) return true;
        else return false;

    }
    public static void main(String[] args){
        new LC444().sequenceReconstruction(new int[]{4,1,5,2,6,3},Arrays.asList(Arrays.asList(5,2,6,3),Arrays.asList(4,1,5,2)));
    }
}
