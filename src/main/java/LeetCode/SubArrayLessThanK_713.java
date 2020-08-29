public class SubArrayLessThanK_713 {
  public int numSubarrayProductLessThanK(int[] nums, int k) {
    int startIdx=0, endIdx=0, oldEndIdx;
    int rt = 0;
    int currentProd = 1;
    while(startIdx<nums.length){
      while(startIdx<nums.length && nums[startIdx]>=k){
        startIdx++;
        endIdx= startIdx;
      }
      oldEndIdx = endIdx;
      while(endIdx<nums.length && (currentProd *=nums[endIdx])<k){
        endIdx++;
      }
      rt+=(nSubArray(endIdx-startIdx) - nSubArray(oldEndIdx-startIdx));
      if(endIdx == nums.length) break;
      while(startIdx<=endIdx && (currentProd/=nums[startIdx++])>=k) {
      }
      currentProd /= nums[endIdx];
    }
    return rt;
  }

  int nSubArray(int l){
    return (l+1)*l/2;
  }

}
