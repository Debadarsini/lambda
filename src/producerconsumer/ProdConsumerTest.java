package producerconsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ProdConsumerTest {

    public static void main(String[] args) {
      ExecutorService executorService =Executors.newCachedThreadPool();
      
      Buffer buffer = new SynchronizedBufferUsingLock();
      
      executorService.execute(new Producer(buffer));
      
      executorService.execute(new Consumer(buffer));
      
      executorService.shutdown();
      
      try {
        executorService.awaitTermination(2, TimeUnit.MINUTES);
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
      
      
      

    }

}
