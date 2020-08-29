import java.util.*;
public class PanCakeSort_969 {
  public List<Integer> pancakeSort(int[] A) {
    List<Integer> rt = new ArrayList<>();
    int target = A.length;
    while(target>1){
      int i = find(A , target-1, target);
      if (i!=target-1){
        reorder(A,i);
        reorder(A,target-1);
      }
      rt.add(i+1);
      rt.add(target);
      target--;
    }
    return rt;

  }
  int find(int[] A , int endIdx, int target){
    for(int i =0;i<=endIdx;i++)
      if(A[i]==target)
        return i;
    return -1;
  }
  void reorder(int[] A,  int endIdx){
    for(int i=0, j=endIdx; i<j; i++,j--)
    {
      int tmp = A[i];
      A[i] = A[j];
      A[j] = tmp;
    }
  }
}
