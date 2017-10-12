package javalambada;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class B {

    static long solve(long n){
        // Complete this function
   
        int arr[] = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
       
        
        
       long  finalNumber = finalNumber(n,arr);
       
        
        return finalNumber;
    }
    
    
    static boolean isValidNumber(long number,int[] arr){
        List fibList = Arrays.asList(0,1,1,2,3,5,8,13);
        int remainder;
        Map<Integer,Integer> freqCount = new HashMap();
        int pos=0;
        while(number>0){
            remainder = (int)(number%10);
            arr[pos] = (int)remainder;
            if(freqCount.containsKey(remainder)){
                freqCount.put(remainder,freqCount.get(remainder)+1);
            }else{
                freqCount.put(remainder,1);
            }
            pos++;
            number = number/10;
        }
         
        
        for(Map.Entry<Integer,Integer> entry : freqCount.entrySet()){
            if(!fibList.contains(entry.getValue())){
                for(int k=0;k<arr.length;k++){
                    if(entry.getKey()==arr[k]){
                        arr[k]= arr[k]+1;
                        break;
                    }
                }
                return false;
            }
        }
        return true;
    }
    
    static long finalNumber(long finalNumber,int[] arr){
        long number=0l;
        if(!isValidNumber(finalNumber,arr)){
            
            for(int l =0;l<arr.length;l++){
                if(arr[l]!=-1){
                    number+=arr[l]*(Math.pow(10,l));
                }
            }
            finalNumber = finalNumber(number,arr);
        }
        return finalNumber;
    }

    
    public static void main(String[] args) {
     //   Scanner in = new Scanner(System.in);
       // int q = in.nextInt();
       // for(int a0 = 0; a0 < q; a0++){
         //   long n = in.nextLong();
          //  long result = solve(n);
            //System.out.println(result);
        //}
        
        Integer x = 1;
        String y = "abc";
        B b = new B();
        b.add(x,y);
        System.out.println(y);
        System.out.println(fib(1110));
        List<B> strList=null;
        List<Object> objects = strList;
    }
    
    
   private void add(Integer x, String y) {
        // TODO Auto-generated method stub
        x+=1;
        y+=1;
        System.out.println(y);
    }


static  int fib(int n){
       //System.arraycopy(src, srcPos, dest, destPos, length);
       int n1=0;
       int n2=1;
       int n3=0;
       for(int i=2;i<n;++i)//loop starts from 2 because 0 and 1 are already printed    
       {    
        n3=n1+n2;    
        System.out.print(" "+n3);    
        n1=n2;    
        n2=n3;    
       } 
       return n3;
       
         
    }
}

