// 2022-07-28
// 도로와 신호등

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //신호등 개수
		int L = Integer.parseInt(st.nextToken()); //총 거리
		int[] traffic_light = new int [N]; //신호등위치
		int[][] times = new int [N][2]; //[0]:빨간불 지속시간, [1]:초록불 지속시간
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			traffic_light[i] = Integer.parseInt(st.nextToken());
			times[i][0] = Integer.parseInt(st.nextToken());
			times[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int current  = 0, second = 0;
		for(int i=0; i<N; i++) {
			second+=traffic_light[i] - current;
			current+=traffic_light[i] - current;
			
			if(times[i][0] > second%(times[i][0]+times[i][1])) { //아직 빨간불 지속시간 중
        //총 지난 시간 / (빨간불 지속시간+초록불지속시간) => 빨간불 지속시간 - 나머지 = 빨간불 남은 지속시간
				second += times[i][0] - second%(times[i][0]+times[i][1]); 
			}
		}
		
		second += L - traffic_light[N-1]; //최종거리-마지막신호등 사이의 거리만큼 초를 더함
		
		System.out.println(second);
	}
}
