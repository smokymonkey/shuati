package LeetCode;
import java.util.*;
public class LC650 {
    public int minSteps(int n) {
        Queue<State> q = new LinkedList<>();
        q.offer(new State(1,0));
        q.offer(null);
        int rt =0;
        while(!q.isEmpty()){
            State current =q.poll();
            if(current==null){
                rt++;
                q.offer(null);
            }else{
                if(current.length==n){
                    break;
                }
                else{
                    if(current.copied!=0)
                        q.offer(new State(current.length+current.copied,current.copied)); //paste
                    if(current.copied!=current.length) //copy all
                        q.offer(new State(current.length,current.length));
                }
            }

        }
        return rt;
    }
    public static void main(String[] args){
        new LC650().minSteps(3);
    }

}
class State{
    int length;
    int copied;
    public State(int _length,int _copied){
        length=_length;
        copied = _copied;
    }
}