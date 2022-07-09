// 2022-07-10
// 별 찍기 - 1

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class backjoon2438 {
    
    public static void main(String args[]) throws IOException {
        
        int N;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}
