package producerconsumer;

import java.util.concurrent.locks.ReentrantLock;

public class UnSynchronizedBuffer implements Buffer{
    
    

    private int buffer=-1;
    
    private boolean occupied=false;
    
    private ReentrantLock lock;
    
    public UnSynchronizedBuffer() {
        super();
        this.lock = new ReentrantLock();
    }

   @Override
    public  synchronized void  blockingPut(int value) throws InterruptedException {
        // TODO Auto-generated method stub
        while(occupied){
            wait();
        }
       
        buffer=value;
        occupied=true;
        notifyAll();
    }

    @Override
    public synchronized int  blockingGet() throws InterruptedException {
        // TODO Auteo-generated method stub
        while(!occupied){
            wait();
        }
       notifyAll();
       occupied=false;
       return buffer;
    }

  /*  public   void  blockingPut(int value) throws InterruptedException {
        // TODO Auto-generated method stub
        final ReentrantLock lock = this.lock;
        try{
        lock.lockInterruptibly();
        while(occupied){
            wait();
        }
       
        buffer=value;
        occupied=true;
        notifyAll();
        }finally{
            lock.unlock();
        }
       
    }

    @Override
    public  int  blockingGet() throws InterruptedException {
        // TODO Auteo-generated method stub
        ReentrantLock lock = this.lock;
        try{
        lock.tryLock();
        while(!occupied){
            wait();
        }
       notifyAll();
       occupied=false;
      
       return buffer;
        }finally{
            lock.unlock();
        }
    }*/
}
