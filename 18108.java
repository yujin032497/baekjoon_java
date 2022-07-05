// 2022-07-05
// 1998년생인 내가 태국에서는 2541년생?!

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		int y;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		y = Integer.parseInt(br.readLine());
		
		System.out.println(y-543);
	}

}
