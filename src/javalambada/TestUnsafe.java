package javalambada;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestUnsafe {
    
    public static void main(String [] args){
        ExecutorService service = Executors.newCachedThreadPool();
        UnSafeClass uc = new UnSafeClass(6);
        service.execute(new AddElementThread(uc, 1));
        service.execute(new AddElementThread(uc, 10));
        service.shutdown();
        
        try {
         boolean taskEnded=   service.awaitTermination(4, TimeUnit.MINUTES);
         if(taskEnded)
             uc.getValues();
             
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
