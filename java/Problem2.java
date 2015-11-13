import java.util.Scanner;
import java.util.*;
// Peter wants to generate some prime numbers for his cryptosystem. Help him! Your task is to generate all prime numbers between two given numbers!

// Input

// The input begins with the number t of test cases in a single line (t<=10). In each of the next t lines there are two numbers m and n (1 <= m <= n <= 1000000000, n-m<=100000) separated by a space.

// Output

// For every test case print all prime numbers p such that m <= p <= n, one number per line, test cases separated by an empty line.

public class Problem2 {
    static BitSet is_checked = new BitSet(1000000010);
    static BitSet bm_primes = new BitSet(1000000010);
    static int start_from = 2;
    public static void main(String[] args) {
        //
        Scanner in = new Scanner(System.in);
        StringBuffer result_string = new StringBuffer();
        // Get Inputs
        int q_count = 0;
        q_count = in.nextInt();
        int[] start_num = new int[q_count];
        int[] end_num= new int[q_count];

        for(int m =0;m<q_count;m++){
            start_num[m] = in.nextInt();
            end_num[m] = in.nextInt();
        }


        // 0 and 1 are not prime
        bm_primes.set(0);
        bm_primes.set(1);

        // Start caculate prime
        for(int m = 0; m < q_count; m++ ){
            if (m > 0){
                System.out.println("");
                // result_string.append("\n");
            }
            int i_end = end_num[m] * 2;

            if(2 != end_num[m] && i_end > start_from){
                double sqrt_end_num =  Math.sqrt(i_end);
                for(int i= start_from;i<= sqrt_end_num;i++ ){
                    if(!bm_primes.get(i)){
                        for(int k = (i_end - 1)/i, j = i*k ; k>=i ; k--, j-=i){
                            if(!bm_primes.get(k)){
                                bm_primes.set(j);
                            }
                        }
                    }
                }
                start_from = i_end;
            }
            if( start_num[m] < 2){
                start_num[m] = 2;
            }
            for(int i=start_num[m];i<=end_num[m];i++){
                if(!bm_primes.get(i)){
                    System.out.println(i + " " + is_prime(i));
                }
            }
        }
    }

    private static boolean is_prime(int n){
      if (n == 2) return true;
      if(n < 2 || n % 2 == 0) return false;
      int u = n - 1, t = 0;
      while(u%2==0){u>>=1;t++;}

      int[] sprp = {2, 7, 61};
      for(int k = 0; k<3; k++){
        int a = sprp[k] % n;
        if(a == 0 || a == 1 || a == n-1) continue;
        int x = 1;
          for(int p = 0;p < u ;p++){
            x = x * a % n;
          }
        if(x == 1 || x ==n-1) continue;

        for(int i=0;i< t-1;i++){
          x = x * x % n;
          if(x==1) return false;
          if(x == n-1) break;
        }
        if(x == n-1) continue;
        return false;
      }
      return true;
    }

}