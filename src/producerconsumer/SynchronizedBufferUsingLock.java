package producerconsumer;

import java.util.Stack;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedBufferUsingLock  implements Buffer{
    
    private final Lock accessLock = new ReentrantLock();
    
    private final Condition canRead = accessLock.newCondition();
    
    private final Condition canWrite = accessLock.newCondition();
    
    private int buffer =-1;
    
    private boolean occupied=false;

    @Override
    public void blockingPut(int value) throws InterruptedException {
        // TODO Auto-generated method stub
        Stack stack = new Stack();
        stack.
        accessLock.lock();
        
        while(occupied){
            canWrite.await();
        }
        
        occupied=true;
        
        buffer=value;
        
        canRead.signalAll();
        accessLock.unlock();
    }

    @Override
    public int blockingGet() throws InterruptedException {
        accessLock.lock();
        
        while(!occupied){
            canRead.await();
        }
        
        occupied=false;
        
      
        
        canWrite.signalAll();
        accessLock.unlock();
        
        return buffer;
    }
    
    
    

}
