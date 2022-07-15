// 2022-07-15
// 설탕 배달

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class backjoon2839 {
	
	static int N; //설탕무게
	
	public static void main(String args[]) throws IOException {
		
		int tmp = 0, min = 0; //봉지개수, 최소봉지개수
		int i=1; //5kg봉지수
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		while(N-5*i>=0) { //설탕무게 - 5kg*i에서 0보다 크거나 같게 한 이유는
                      //설탕무게가 15kg인경우: 15-5*3일경우 (5kg으로 다 옮길 수 있다) 
			
			if((N-5*i)%3==0) {
				tmp = i+(N-5*i)/3;
				if(min==0) {
					min = tmp;
				}else if(tmp<min) {
					min = tmp;
				}
			}
			i++;
		}
		
		if(N%3==0) { //5kg로 안될경우: 3kg로만 옮긴경우
			tmp = N/3;
			if(min==0) {
				min = tmp;
			}else if(tmp<min) {
				min = tmp;
			}
		}
		
		if(min==0) min=-1; //min=0인경우: 5kg, 3kg으로 옮겨도 남는경우(-1)
		
		System.out.println(min); //
	}

}
