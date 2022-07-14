// 2022-07-14
// 주유소

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N; //도시 개수
	static long [] distance; //도시와 도시사이 거리
	static long [] city; //도시별 가격
	static long min_cost, ans = 0; //최저가격, 총비용
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		distance = new long[N-1];
		city = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N-1; i++) {
			distance[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			city[i] = Integer.parseInt(st.nextToken());
		}
		
		min_cost = city[0]; //최저비용을 첫번쨰 도시의 단가로 초기화
		for(int i=0; i<N-1; i++) {
			
			if(city[i]<min_cost) { //도시의 단가<최저비용 => 최저비용 갱신
				min_cost = city[i];
			}
			ans+=distance[i]*min_cost; //도시사이거리 * 최저비용
			
		}
		System.out.println(ans);
	}

}

/*int가 아닌 long으로 해야 100점으로 채점*/
