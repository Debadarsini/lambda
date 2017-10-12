package javalambada;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

//Lambda is short hand of functional interface
class Checker implements Comparator<Player>{

    @Override
    public int compare(Player p1, Player p2) {
        if(p1.name.compareTo(p2.name)!=0){
            return p1.name.compareTo(p2.name);
        }
        return Integer.compare(p1.getClass(), y);
    }

   
    
    
}
class Player{
    String name;
    int score;
    
    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

public class A implements Comparator<T>{
    
    
    <T> void printArray(T[] array){
        for(T t : array){
            System.out.println(t);
        }
    }

    static int abc =123;
    public static void main(String[] args){
        A a = new A();
        int def =123;
        String [] arr = new String[10];
        List[] arrs = new ArrayList[5];
        
      /*  Arrays.sort(arr,Collections.reverseOrder( (String s1, String s2)->{ 
            BigDecimal b1 = new BigDecimal(s1);
            BigDecimal b2 = new BigDecimal(s2);
               return b1.compareTo(b2);})
          );*/

        BigInteger b1 = new BigInteger("123");
        b1.isProbablePrime(1);
        System.out.println(b1.isProbablePrime(1)?"Prime" :"Not Prime");
       // new Thread(()->{def=345;System.out.println(def);}).start();
       
        Thread th = new Thread(()->{System.out.println(a.abc+=10);});
       
        Thread th1 = new Thread(()->{System.out.println(a.abc+=10);});
        
        ExecutorService service = Executors.newCachedThreadPool();
        
        service.submit(th);
        service.submit(th1);
        
        service.shutdown();
        
        
        System.out.println(a.abc);
        
        int [] abc = {1,2,4,6};
        
        System.out.println(Arrays.stream(abc).parallel().max().getAsInt());
        
        
        List<Employee> employees = Arrays.asList(new Employee(10,"abc",200f,"IT"),new Employee(2,"def",202.5f,"IT"),
                new Employee(3,"xyz",202.3f,"FINANCE"));
        
        Map<String, Long> groupByDepartMent = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
        groupByDepartMent.forEach((department,employeesInDept)->System.out.println(department+"   "+employeesInDept));
      //  employeesInDept.forEach(System.out::println);});
        //Predicate<Employee> p = e -> e.getSalary()>300&&e.getSalary()<402.5;
      //  Comparator<Employee> compare1 = ( e1, e2)->  e1.getNo()-e2.getNo());
      //  employees.stream().filter(p).sorted( Comparator.comparing(Employee :: getSalary)).forEach(System.out::println);;
        
        int [] values = {5,2,3,4};
        String [] strings = {"abc","def","ghi","klm"};
      //  System.out.println(Arrays.stream(strings).map(String::toUpperCase).collect(Collectors.toList()));
        //System.out.println(Arrays.stream(values).sorted().collect(Collectors.toList()));
     //   System.out.println(IntStream.of(values).reduce(0,(x,y)->x+y));
       // System.out.println(IntStream.of(values).reduce(1,(x,y)->{System.out.println(x);
        //System.out.println(y);return x+y;}));
        //Comparator<Employee> compare1 = ( e1, e2)->  e1.getNo()-(e2.getNo());
       // Collections.sort(Arrays.asList(employees),( e1, e2)->  e1.getNo()-(e2.getNo()));
        
  //     IntStream.of(values).filter(value->value%2!=0).map(value->value*10).sorted().forEach(System.out::println);
        
     //   System.out.println(IntStream.range(1, 2).sum());
     //   System.out.println(Arrays.toString(values));
       /* IntStream.of(values).forEach(value->System.out.println(value));
        
        IntStream.of(values).forEach(new IntConsumer() {
            
            @Override
            public void accept(int value) {
                System.out.println(value);
                
            }
        });
        
       System.out.println(IntStream.of(values).average().orElse(10)); 
      Arrays.asList(employees).stream().forEach(employee -> {System.out.println(employee.getName());
      System.out.println(a.abc);});
      
     // System.out.println(Arrays.asList(employees).stream().filter(e ->e.getNo()==123).map(emp->));
     
      System.out.println( IntStream.of(values).average().getAsDouble());
      
      System.out.println(IntStream.of(values).isParallel());
      System.out.println(IntStream.of(values).findFirst().getAsInt());
    }*/
    }
    @Override
    public int compare(javalambada.T o1, javalambada.T o2) {
        // TODO Auto-generated method stub
        return 0;
    }
}
