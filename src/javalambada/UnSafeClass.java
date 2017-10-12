package javalambada;

import java.util.Arrays;

public class UnSafeClass {
    
    private int[] arrays;
    
    private int index;
    
    public UnSafeClass(int size) {
        arrays = new int[size];
        index =0;
    }

    
     synchronized void addElement(int value){
        System.out.println("enter thread "+Thread.currentThread().getName()+" "+index);
        arrays[index]=value;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        index++;
        System.out.println("exit thread "+Thread.currentThread().getName()+" "+index);
        
    }
    
    void getValues(){
        System.out.println(Arrays.toString(arrays));
    }
}
