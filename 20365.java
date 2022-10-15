import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		String str = in.readLine();
		
		int[] color = new int [2];
		
		if(str.charAt(0) == 'R') color[0]+=1; // 처음에 빨간색을 칠해야한다면 빨간색에 더하고 파란색이면 파란색에 더한다.
		else color[1]+=1;
		
		for(int i=1; i<N; i++) {
			if(str.charAt(i)!=str.charAt(i-1)) { // 색이 달라질때마다
				if(str.charAt(i)=='R') color[0]+=1; // 달라지는 색에 +1 증가
				else color[1]+=1;
			}
		}
		// 마지막에 +1을 더해주는 이유는 min에 해당 하는 색말고 다른 색을 한번은 칠해야하기 때문
		System.out.println(Math.min(color[0], color[1])+1); 
	}
}
