// 2022-07-17
// 최소, 최대

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N; //정수 N개
	static int [] arr; //정수 배열
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
    		//정수입력
		for(int i=0; i<N; i++) {
			
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
    		//오름차순 정렬
		Arrays.sort(arr);
		
    		//출력
		System.out.printf("%d %d",arr[0], arr[arr.length-1]);
	}
}
