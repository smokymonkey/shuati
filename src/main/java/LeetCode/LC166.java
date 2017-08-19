package LeetCode;

/**
 * Created by jie on 7/12/17.
 */
import java.util.*;
public class LC166 {
    public static String fractionToDecimal(int _numerator, int _denominator) {

        long numerator = (long)_numerator;
        long denominator = (long)_denominator;

        StringBuilder sb =new StringBuilder();
        numerator = numerator>0?numerator:-numerator;
        denominator = denominator>0?denominator:-denominator;
        sb.append(numerator/denominator);
        if(numerator%denominator!=0){
            sb.append(".");
            List<Long> fraction=new ArrayList<>();
            Map<Long,Integer> m = new HashMap<>();
            numerator%=denominator;
            while(numerator!=0 && !m.containsKey(numerator)){
                m.put(numerator,fraction.size());
                long f = (numerator*10)/denominator;
                fraction.add(f);

                numerator=numerator*10;
                numerator=numerator%denominator;
            }
            if(numerator==0){
                for(Long i:fraction)
                    sb.append(i);
            }else{
                int j=m.get(numerator);
                for(int i=0;i<fraction.size();i++){
                    if(i==j)
                        sb.append('(');
                    sb.append(fraction.get(i));
                }
                sb.append(')');
            }
        }
        if((_numerator>0 && _denominator<0) || (_numerator<0 && _denominator>0) ) sb.insert(0,'-');
        return sb.toString();
    }
    public static void main(String[] args){
        fractionToDecimal(-1,-2147483648);
    }
}
