import LeetCode.LC149;
import LeetCode.Point;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jie on 5/28/17.
 */
public class LC149Test
{

    LC149 lc149=new LC149();
    @Test
    public void test1(){
        int answer = lc149.solution1(new Point[]{new Point(1,1),new Point(1,1),new Point(2,2),new Point(2,2)});
        Assert.assertEquals(4,answer);
    }

    @Test
    public void test2(){
        int answer =lc149.solution1(new Point[]{new Point(1,1)});
        Assert.assertEquals(1,answer);

    }
    @Test
    public void test3(){
        int answer =lc149.solution1(new Point[0]);
        Assert.assertEquals(0,answer);

    }
    @Test
    public void test4(){
        int ans=lc149.solution1(new Point[]{new Point(0,0),new Point(0,1),new Point(2,1),new Point(-2,1)});
        Assert.assertEquals(3,ans);
    }
    @Test
    public void test5(){
        int ans=lc149.solution1(new Point[]{new Point(1,0),new Point(0,1),new Point(1,1),new Point(1,-1)});
        Assert.assertEquals(3,ans);
    }

    @Test
    public void test6(){
        int ans=lc149.solution1(new Point[]{new Point(1,1),new Point(1,1),new Point(1,1)});
        Assert.assertEquals(3,ans);
    }
    @Test
    public void test7(){
        int ans=lc149.solution1(new Point[]{new Point(0,0),new Point(94911151,94911150),new Point(94911152,94911151)});
        Assert.assertEquals(2,ans);
    }

}
