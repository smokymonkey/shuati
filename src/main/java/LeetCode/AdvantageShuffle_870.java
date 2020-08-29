import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class AdvantageShuffle_870 {
  public int[] advantageCount(int[] A, int[] B) {
    int l = A.length;
    TreeMap<Integer, List<Integer>> m = new TreeMap<>();
    Arrays.sort(A);
    for(int i =0;i<l;i++){
      if(!m.containsKey(B[i]))
        m.put(B[i],new ArrayList<>());
      m.get(B[i]).add(i);
    }
    int[] rt = new int[l];
    for(int i = 0;i<l;i++)
      rt[i]=-1;
    Set<Integer> used = new HashSet<>();
    int start =0;
    for(Integer i : m.keySet()){
      List<Integer> index = m.get(i);
      for(Integer j:index){
        while(start<l && A[start]<=i)
          start++;
        if(start<l){
          rt[j]=start;
          used.add(start);
          start++;
        }
      }
    }
    start = 0;
    for(int i =0;i<l;i++){
      if(rt[i]==-1){
        while(used.contains(start))
          start++;
        rt[i] = A[start];
        start++;
      }else{
        rt[i]=A[rt[i]];
      }
    }
    return rt;
  }

  int findMinGreater(int[] A, int start, int end, int target , boolean[] used){
    if(start == end && A[start]>target) return start;
    if(start>end || end<0 || start>=A.length) return -1;

    int mid = A[(start+end)/2];
    if (mid == target) {
      int i = (start+end)/2;
      while (i<=end && (A[i]==target || used[i])) i++;
      if(i<=end) {
        used[i]=true;
        return i;
      }else
        return -1;
    }
    else if(mid<target) return findMinGreater(A,(start+end)/2+1, end,target,used);
    else return findMinGreater(A,start, (start+end)/2-1, target,used);
  }
  public static void main(String[] args){
    new AdvantageShuffle_870().advantageCount(new int[]{2,7,11,15}, new int[]{1,10,4,11} );
  }
}
