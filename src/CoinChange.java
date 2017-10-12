import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CoinChange {

    static long getWays(long n, long[] c){
        Map<Long,Long> table = new HashMap<Long,Long>();
        table.put(0l,1l);
        for(long k=1;k<n+1;k++){
            table.put(k,0l);
        }
        int noOfCoins = c.length;
        for(int i=0;i<noOfCoins;i++){
            for(long j=c[i];j<=n;j++){
                  table.put(j,table.get(j)+table.get(j-c[i]));
            }
        }
        return table.get(n);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[] c = new long[m];
        for(int c_i=0; c_i < m; c_i++){
            c[c_i] = in.nextLong();
        }
        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
        long ways = getWays(n, c);
        System.out.println(ways);
    }
}

