// 2022-10-16
// 평범한 배낭 2

import java.io.*;
import java.util.*;

public class Main {
	
	static class Product {
		int weight;
		int value;
		
		public Product(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}
	}
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 물건의 종류의 수
		int M = Integer.parseInt(st.nextToken()); // 민호가 들 수 있는 가방의 최대 무게
		
		ArrayList<Product> list = new ArrayList<>();
		list.add(new Product(0,0)); // index를 1부터 하기 위해 빈값을 넣어준다.
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			int v = Integer.parseInt(st.nextToken()); // 물건의 무게
			int c = Integer.parseInt(st.nextToken()); // 물건을 가방에 넣었을 떄 올라가는 민호의 만족도
			int k = Integer.parseInt(st.nextToken()); // 물건의 개수
			
			int n = 1;
			while(n<=k) { // 무게를 제곱단위로 나눠서 넣어줌: 1, 2, 4, 8 ...
				
				list.add(new Product(v*n, c*n));
				k-=n;
				
				n*=2;
			}
			
			if(k!=0) {
				list.add(new Product(v*k, c*k)); // 무게를 제곱하여 나눠서 넣어주고 나머지를 추가
			}
		}
		
		int [][] dp = new int [list.size()+1][M+1]; // 메모이제이션
		
		for(int i=1; i<list.size(); i++) {
			for(int j=1; j<=M; j++) {
				dp[i][j] = dp[i-1][j]; // 이전물건에 대한 데이터로 초기화
				if(j-list.get(i).weight>=0) { // 비교하려는 무게 - 현재 물건의 무게 >= 0 : 민호가 들 수 있는 무게
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-list.get(i).weight]+list.get(i).value);
				}
			}
		}
		
		System.out.println(dp[list.size()-1][M]);
		
	}
}
