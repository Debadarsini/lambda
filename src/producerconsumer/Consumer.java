package producerconsumer;

public class Consumer implements Runnable{

    private Buffer buffer;
    
    Consumer(Buffer buffer){
        this.buffer=buffer;
    }
    
    @Override
    public void run() {
        int sum=0;
        // TODO Auto-generated method stub
        for(int count=1;count<=10;count++){
            try {
               //buffer.blockingGet();
                System.out.println("Consumer reads "+ buffer.blockingGet());
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
