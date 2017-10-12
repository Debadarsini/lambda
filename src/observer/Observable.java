package observer;

import java.util.HashSet;
import java.util.Set;

public interface Observable {
    
    Set<Observer> observers = new HashSet();
    
     default void addObserver(Observer observer){
         observers.add(observer);
     }
     
     default void noiffyObserver(){
       observers.forEach( observer -> {observer.update(this);});   
     }

     abstract int getValue();

}
