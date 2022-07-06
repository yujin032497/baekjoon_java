// 2022-07-07
// 줄 세우기

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	public static void main(String args[]) throws IOException {
		
		int i;
		int N;
		int idx; //인덱스 순서
		ArrayList<Integer> arr = new ArrayList<Integer>(); //나열한 수
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //몇 개의 수를 뽑을 것인지
		
		StringTokenizer st = new StringTokenizer(br.readLine()); //순서 뽑기
		
		arr.add(Integer.parseInt(st.nextToken()),1); //첫 번째 수는 무조건 제일 앞에
		
		for(i=2; i<N+1; i++) { //2부터 시작
			idx = Integer.parseInt(st.nextToken());
			arr.add(i-idx-1, i); //i번째에서 뽑은 순서 만큼 뺀 후 -1 
		}
		
		for(i=0; i<arr.size(); i++) {
			System.out.print(arr.get(i).toString()+" ");
		}
		
	}

}
