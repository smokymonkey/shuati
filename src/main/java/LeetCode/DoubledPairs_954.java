import java.util.*;
public class DoubledPairs_954 {
    public boolean canReorderDoubled(int[] A) {
        Map<Integer,Integer> count = new HashMap();
        for (int i =0; i<A.length; i++)
            insertToMap(count,A[i]);
        if (count.containsKey(0))
            if (count.get(0)%2!=0)
                return false;
            else
                count.remove(0);

        for (int i: count.keySet()){
            if (count.get(i) == 0) continue;
            if(isSmallStart(count,i))
                squeezFromSmall(count,i);
            else if(isBigStart(count,i))
                squeezFromBig(count,i);

        }
        for (int i: count.keySet()){
            if (count.get(i)>0)
                return false;
        }
        return true;
    }

    void squeezFromSmall(Map<Integer,Integer> count, int i){
        int value = i;
        int c = count.get(value);
        while(c>0 && count.containsKey(value*2) && count.get(value*2)>=c){
            removeFromMap(count, value, c);
            removeFromMap(count, value*2,c);
            value *= 2;
            c = count.get(value);
        }
    }

    void squeezFromBig(Map<Integer,Integer> count, int i){
        int value = i;
        int c = count.get(value);
        while(isBigStart(count, value) && c>0 && count.containsKey(value/2) && count.get(value/2)>=c){
            removeFromMap(count, value, c);
            removeFromMap(count, value/2,c);
            value /= 2;
            c = count.get(value);
        }
    }

    boolean isSmallStart(Map<Integer,Integer> m, int i ){
        return (i%2 !=0 || !m.containsKey(i/2) ||m.get(i/2)==0) && m.get(i)>0;
    }

    boolean isBigStart(Map<Integer,Integer> m, int i ){
        return i%2 ==0 && (!m.containsKey(i*2) || m.get(i*2)==0) && m.get(i)>0;
    }

    void insertToMap(Map<Integer,Integer> m, int i){
        if(m.containsKey(i))
            m.put(i,m.get(i)+1);
        else
            m.put(i,1);
    }

    void removeFromMap(Map<Integer,Integer> m,int i,int count){
        if(m.containsKey(i))
            m.put(i,m.get(i)-count);
    }

    public static void main(String[] args){
        int[] input1 = new int[]{3,1,3,6};
        System.out.println(new DoubledPairs_954().canReorderDoubled(input1));
    }
}
