// 2022-07-20
// 평균

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //점수 개수
		double[] arr = new double [N]; //점수 배열
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); //입력한 점수를 배열에 넣기
		}
		
		Arrays.sort(arr);//배열을 오름차순으로 정렬
    
		double M = arr[arr.length-1];//배열의 마지막 인덱스 위치: 최대값
		double sum = 0, avg = 0; //점수 합계, 평균
		
		for(int i=0; i<N; i++) {
			sum += arr[i]/M*100; //점수 재계산하여 더한다.
		}
		avg = sum/N; //평균 구하기
		
		System.out.printf("%.6f",avg); //소숫점 6자리까지 출력
		
	}

}
