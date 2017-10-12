package observer;

public class NewClient implements Observer {

    public static void main(String [] args){
        
           Temperature temp = new Temperature();
           new Thread(()->{ 
               for(int i=1;i<100;i++){
                temp.uodateValue(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
               }
           }).start();
        
          temp.addObserver(new NewClient());
    }
    
}
