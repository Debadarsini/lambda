package producerconsumer;

public class CircularBuffer implements Buffer {
    
    private int[] buffer = {-1,-1,-1};
    
    private int occupiedCells=0;
    
    private int writeIndex=0;
    
    private int readIndex=0;

    @Override
    public  synchronized void blockingPut(int value) throws InterruptedException {
        while(occupiedCells == buffer.length){
            wait();
        }
        
        buffer[writeIndex] = value;
        writeIndex =(writeIndex+1)%buffer.length;
        ++occupiedCells;
        //readIndex++;
        notifyAll();
        
    }

    @Override
    public synchronized int blockingGet() throws InterruptedException {
        // TODO Auto-generated method stub
        while(occupiedCells==0){
            wait();
        }
      //  writeIndex--;
        int value = buffer[readIndex];
        
        readIndex= (readIndex+1) % buffer.length;
       
        --occupiedCells;
        
        notifyAll();
       
        return value;
     
    }

}
