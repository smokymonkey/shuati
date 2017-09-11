package ConsistentHashing;

/**
 * Created by jo0235 on 9/10/17.
 */
import com.google.common.hash.*;

import java.io.UnsupportedEncodingException;
import java.util.TreeMap;

public class Master {
    TreeMap<Long,Worker> partition =new TreeMap<>();

    public void addMachine(Worker worker,int n){
        HashFunction hashFunction = Hashing.murmur3_128();
        for(int i=0;i<n;i++) {
            HashCode hashCode = null;
            try {
                hashCode = hashFunction.hashBytes((worker.getDomainName() + String.valueOf(i)).getBytes("UTF8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            Worker next = partition.ceilingEntry()
            partition.put(hashCode.asLong(),worker);
        }

    }
    public void removeMachine(String domainName){

    }
    public void addData(String key ,Object data){

    }
}