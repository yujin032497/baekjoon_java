// 2022-07-09
// 알람 시계

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws IOException {
		
		int H,M;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken()); //시
		M = Integer.parseInt(st.nextToken()); //분
		
		M-=45; //45분 일찍 알람 설정
		
		if(M<0) {
			M+=60;
			H--;
		}
		
		if(H<0) { //시간이 0보다 작으면
			H+=24; //24를 더한다. 0시에서 -45분을 빼면 -1시
             //-1시에서 +24를 더하면 23시('시' 가 -인만큼 시계의 시침 뒤로 간다.)
		}
		
		System.out.println(H+" "+M);
	}

}
