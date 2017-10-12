import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main (String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        
        int noRequests = sc.nextInt();
        
        System.out.println(noRequests);
        String str="";
        char c;
        int times;
        for(int k=0;k<noRequests;k++){
            str = sc.next();
            System.out.println(str);
            c = sc.next().charAt(0);
            System.out.println(c);
            String x = sc.next();
            times = Integer.parseInt(x);
            for(int j=0;j<str.length();j++){
                if(times==0){
                    System.out.println(str.substring(j,str.length()));
                    break;
                }
                if(str.charAt(j)==c ){
                   times--;
                }
            }
        }
    }
}