import org.junit.Assert;
import org.junit.Test;

public class ShuatiTest {
  @Test
  public void testAdvantageShuffle(){
    Assert.assertArrayEquals(new int[]{2,11,7,15},new AdvantageShuffle_870().advantageCount(new int[]{2,7,11,15}, new int[]{1,10,4,11} ));
    Assert.assertArrayEquals(new int[]{24,32,8,12},new AdvantageShuffle_870().advantageCount(new int[]{12,24,8,32}, new int[]{13,25,32,11} ));
  }
  @Test
  public void testPanCakeSort(){
    new PanCakeSort_969().pancakeSort(new int[]{3,2,4,1});
  }

  @Test
  public void testNumSubarrayProductLessThanK(){
    new SubArrayLessThanK_713().numSubarrayProductLessThanK(new int[]{3,2,4,5,100,3,2,4,5,100},23);
  }
}
