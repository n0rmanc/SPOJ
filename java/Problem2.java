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
    static int last_caculated = 2;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        int q_count = 0;
        q_count = in.nextInt();
        int[] start_num = new int[q_count];
        int[] end_num= new int[q_count];

        for(int m =0;m<q_count;m++){
            start_num[m] = in.nextInt();
            end_num[m] = in.nextInt();
        }



        for(int m = 0; m < q_count; m++ ){
            // start_num = in.nextInt();
            // end_num = in.nextInt();
            bm_primes.clear(0);
            bm_primes.clear(1);
            int i_end = end_num[m] * 2;
            // ArrayList<Integer> i_primes = new ArrayList<>(10000000);
            if(2 != end_num[m] && i_end > last_caculated){
                double sqrt_end_num =  Math.sqrt(i_end);
                for(int i= last_caculated;i<= sqrt_end_num;i++ ){
                    if(!bm_primes.get(i)){
                        // for(int j = i *i; i<= i_end;j = j + i){
                        //     bm_primes.set(j);
                        // }
                        for(int k = (i_end - 1)/i, j = i*k ; k>=i ; k--, j-=i){
                            if(!bm_primes.get(k)){
                                bm_primes.set(j);
                            }
                        }
                    }
                }
                last_caculated = i_end;
            }

            for(int i=start_num[m];i<=end_num[m];i++){
                if(!bm_primes.get(i)){
                    System.out.println(i);
                }
            }
            System.out.println("");
        }


    }

}