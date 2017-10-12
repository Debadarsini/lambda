package observer;

public interface Observer {
    
    
    default void update(Observable observable){
        System.out.println("temp updated "+observable.getValue());
    }
   
}
