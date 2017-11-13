package ConsistentHashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jo0235 on 9/11/17.
 */
public class Worker {
    private Map<String, Object> dataStore=new HashMap<>();
    private String domainName;
    public Worker(String domainName){
        this.domainName=domainName;
    }
    public void addData(String key,Object data){
        dataStore.put(key,data);
    }
    public void removeData(String key){
        dataStore.remove(key);
    }
    public String getDomainName(){
        return domainName;
    }
}
