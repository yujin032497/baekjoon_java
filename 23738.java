// 2022-10-05
// Ресторан 

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		str = str.toLowerCase();
	
		str = str.replace("b", "v");
		str = str.replace("h", "n");
		str = str.replace("p", "r");
		str = str.replace("c", "s");
		str = str.replace("y", "u");
		str = str.replace("x", "h");
		str = str.replace("e", "ye");

		System.out.println(str);
	}
}
