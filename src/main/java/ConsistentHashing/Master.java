package ConsistentHashing;

/**
 * Created by jo0235 on 9/10/17.
 */
import com.google.common.hash.*;

import java.io.UnsupportedEncodingException;
import java.util.TreeMap;

public class Master {
    TreeMap<Long,Worker> partition =new TreeMap<>();
    HashFunction hashFunction = Hashing.murmur3_128();
    public void addMachine(Worker worker,int n){

        for(int i=0;i<n;i++) {
            HashCode hashCode = null;
            try {
                hashCode = hashFunction.hashBytes((worker.getDomainName() + String.valueOf(i)).getBytes("UTF8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

//            Worker next = partition.ceilingEntr();
            partition.put(hashCode.asLong(),worker);

        }

    }
    public void removeMachine(String domainName){

    }
    public void addData(String key ,Object data){

    }
    public long getHash(String  key){
        HashCode hashCode = null;
        try {
            hashCode = hashFunction.hashBytes(key.getBytes("UTF8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return hashCode.asLong();
    }
}
