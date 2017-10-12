package producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockingArrayBuffer implements Buffer{
    
    private final ArrayBlockingQueue<Integer> buffer;
    
    

    public BlockingArrayBuffer() {
        this.buffer = new ArrayBlockingQueue<>(1);
    }

    @Override
    public void blockingPut(int value) throws InterruptedException {
        // TODO Auto-generated method stub
        buffer.put(value);
    }

    @Override
    public int blockingGet() throws InterruptedException {
        // TODO Auto-generated method stub
        return buffer.take();
    }

}
