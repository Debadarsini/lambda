package observer;

public class Temperature implements Observable{
    
    int value;
   
    public void uodateValue(int value) {
       this.value=value;
        this.noiffyObserver();
    }
    
    public int getValue(){
        return value;
    }

}
