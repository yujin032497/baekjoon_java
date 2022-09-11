// 2022-09-12
// 밥

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static class Day implements Comparable<Day> {
		int pointA;
		int pointB;
		int sub;
		
		public Day(int pointA, int pointB) {
			this.pointA = pointA;
			this.pointB = pointB;
			this.sub = Math.abs(pointA-pointB);
		}

		@Override
		public int compareTo(Day o) {
			return o.sub - this.sub; // 두 점수의 차이가 큰 거 부터 
		}
	}
	static int N, X;
	static ArrayList<Day> list = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 메뉴개수
		X = Integer.parseInt(st.nextToken()); // X원 이하
		int totPrice = 0;
		int totPoint = 0;
		int ans = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			// 초기는 B메뉴를 전부 선택했을 경우
			totPrice += 1000;
			totPoint += B;
			
			list.add(new Day(A,B));
		}
		
		Collections.sort(list);
		
		if(X==totPrice) ans = totPoint;
		else {
			int idx = 0;
			while(idx!=list.size()-1) {
				
				int pointA = list.get(idx).pointA;
				int pointB = list.get(idx).pointB;
				
				int tmpPoint = totPoint;
				
				tmpPoint-=pointB;
				tmpPoint+=pointA;
				
				if(tmpPoint>=totPoint) {
					totPrice+=4000;
					
					if(totPrice<=X) {
						totPoint-=pointB;
						totPoint+=pointA;	
					} else {
						totPrice-=4000;
					}
					
					if(totPrice>=X) break;
				}
				
				idx+=1;
			}
			
			ans = totPoint;
		}
		
		System.out.println(totPoint);
	}
}
