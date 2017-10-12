package javalambada;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestExcutoe {
    
    public static void main(String [] args){
    
  
    
    ExecutorService executor = Executors.newCachedThreadPool();
    
    executor.execute(()->{
        System.out.println(Thread.currentThread().getName()+" start");
                 try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                 System.out.println(Thread.currentThread().getName()+" end");
    });
    executor.execute(()->{
        System.out.println(Thread.currentThread().getName()+" start");
         try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" end");
        });

    executor.execute(()->{
        System.out.println(Thread.currentThread().getName()+" start");
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" end");
        }
      );
    

    executor.shutdown();
    }
}
