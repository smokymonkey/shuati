public class BinarySearch {
  public int binarySearch(int[] a, int target, int start, int end){
    if(start>end) return -1;
    int mid = (start+end)/2;
    if(a[mid]==target) return mid;
    else if(a[mid]>target) return binarySearch(a, target,start,mid-1);
    else return binarySearch(a, target,mid+1,end);
  }

//  public int minGreater(int[] a, int target, int start, int end){
//    if(a[start]>target) return start;
//    if(a[end]<=target) return -1;
//    int mid = (start+end)/2;
//    if(a[mid]==target) {
//      for (int i = mid; i <= end; i++)
//        if (a[i] > target)
//          return i;
//    }
//    else if(a[mid]>target)
//      if(a[mid-1])
//      return binarySearch(a, target,start,mid);
//    else return binarySearch(a, target,mid+1,end);
//    return -1;
//  }

  public int minGreater1(int[] a, int target, int start, int end){
    if(start>end) return -1;
    int mid = (start + end)/2;
    if(a[mid]<=target){
      if(mid+1>end) return -1;
      else if (a[mid+1]>target) return mid+1;
      else return minGreater1(a, target, mid+1,end);
    }else{
      if((mid-1)<start || a[mid-1]<=target) return mid;
      else return minGreater1(a,target,start ,mid-1);
    }
  }
}
