package javalambada;

public class AddElementThread implements Runnable{
    
    private UnSafeClass unsafe;
    
    private int value;
    
    AddElementThread(UnSafeClass unsafe,int value){
        this.unsafe=unsafe;
        this.value=value;
    }

    @Override
    public void run() {
        for(int i=value;i<value+3;i++){
            unsafe.addElement(i);
        }
    }

    
}
