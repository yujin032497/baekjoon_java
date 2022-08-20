// 2022-08-20
// 저항

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static String[] color = {"black","brown","red","orange","yellow","green","blue","violet","grey","white"};
	static long[] value = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	static long[] mux = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		long ans = 0;
		for(int i=0; i<3; i++) {
			String str = in.readLine();
			int idx = Arrays.asList(color).indexOf(str);
			if(i==0) {
				ans += value[idx]*10;
			} else if(i==1) {
				ans += value[idx];
			} else {
				ans*= mux[idx];
			}
		}
		
		System.out.println(ans);
	}
}
