import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BinarySearchTest {
  @Test
  public void testBinarySearch(){
    int[] l = new int[]{1,2,5,6,9,13,67,129};
    BinarySearch binarySearch = new BinarySearch();
    assertEquals(-1, binarySearch.binarySearch(l,0,0, l.length-1));
    assertEquals(0, binarySearch.binarySearch(l,1,0, l.length-1));
    assertEquals(-1, binarySearch.binarySearch(l,7,0, l.length-1));
    assertEquals(4, binarySearch.binarySearch(l,9,0, l.length-1));
    assertEquals(7, binarySearch.binarySearch(l,129,0, l.length-1));
    assertEquals(-1, binarySearch.binarySearch(l,130,0, l.length-1));
  }

  @Test
  public void testMinGreater(){
    int[] l = new int[]{1,2,5,6,9,13,67,129};
    BinarySearch binarySearch = new BinarySearch();
    assertEquals(0, binarySearch.minGreater1(l,0,0, l.length-1));
    assertEquals(1, binarySearch.minGreater1(l,1,0, l.length-1));
    assertEquals(-1, binarySearch.minGreater1(l,130,0, l.length-1));
    assertEquals(-1, binarySearch.minGreater1(l,129,0, l.length-1));
    assertEquals(2, binarySearch.minGreater1(l,4,0, l.length-1));
  }


}
