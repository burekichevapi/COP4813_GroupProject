
package repository;

import java.util.List;
import java.util.ArrayList;


public class ThreadRepository {
    
    public List<Thread> getThreads() {
        
        List<Thread> threads = HibernateHelper.getListData(Thread.class);
        return threads;
    }
    
}
