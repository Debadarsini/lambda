package producerconsumer;

public class Producer implements Runnable{
    
    private Buffer buffer;
    
    Producer(Buffer buffer){
        this.buffer=buffer;
    }
    

    @Override
    public void run() {
        int sum=0;
        for(int count=1;count<=10;count++){
            try {
              //  Thread.sleep(10);
              //  sum+=count;
                
                System.out.println(" producer writes ::"+count);
                buffer.blockingPut(count);
                Thread.sleep(100);
                
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
       // System.out.println("sum after producer  "+sum);
    };

}
