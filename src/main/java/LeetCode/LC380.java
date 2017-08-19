package LeetCode;

/**
 * Created by jie on 7/12/17.
 */
import java.util.*;
public class LC380 {
    public static void main(String[] args){
        RandomizedSet randomizedSet=new RandomizedSet();
        randomizedSet.insert(0);
        randomizedSet.remove(0);
        randomizedSet.insert(-1);
        randomizedSet.remove(0);
        randomizedSet.getRandom();
        randomizedSet.getRandom();
        randomizedSet.getRandom();
        randomizedSet.getRandom();
        randomizedSet.getRandom();
        randomizedSet.getRandom();
        randomizedSet.getRandom();
        randomizedSet.getRandom();
        randomizedSet.getRandom();
        randomizedSet.getRandom();

    }
}
 class RandomizedSet {

    Map<Integer,Integer> locations = new HashMap<>();
    List<Integer> value=new ArrayList<>();
    /** Initialize your data structure here. */
    public RandomizedSet() {

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(locations.containsKey(val))
            return false;
        value.add(val);
        locations.put(val,value.size()-1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(locations.containsKey(val) ){
            int toremoveIndex=locations.remove(val);
            if(toremoveIndex!=value.size()-1) {
                int tomove = value.get(value.size() - 1);
                value.set(toremoveIndex, tomove);
                locations.put(tomove, toremoveIndex);
             }
            value.remove(value.size() - 1);
            return true;
        }else
            return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random r = new Random();
        return value.get(r.nextInt(value.size()));
    }
}