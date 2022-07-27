// 2022-07-27
// 기타줄

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //끊어진 기타줄
		int M = Integer.parseInt(st.nextToken()); //브랜드 개수
		
        	//세트 가격, 낱개 가격 초기화는 1000 (가격은 1000보다 작거나 같을 수 있으므로)
		int min_unit_price = 1000, min_set_price = 1000;
		int price = Integer.MAX_VALUE; //최종 최소 가격
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			min_set_price = Math.min(min_set_price,Integer.parseInt(st.nextToken())); //기타 세트 가격 중 최소값
			min_unit_price = Math.min(min_unit_price,Integer.parseInt(st.nextToken())); //기타 낱개 가격 중 최소값
		}
		/*각각의 최솟값의 경우를 min()으로 비교하여 최솟값 구하기*/
		//낱개로만 구입했을 경우
		price = Math.min(price, min_unit_price*N);
		
        //낱개와 세트를 함께 구입했을 경우
		price = Math.min(price, ((N/6) * min_set_price) + ((N%6) * min_unit_price));
		
        //세트로만 구입했을 경우
        price = Math.min(price, (N/6+1) * min_set_price);
		
		System.out.println(price);
	}

}
