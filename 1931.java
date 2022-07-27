// 2022-07-27
// 회의실 배정

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] time = new int [N][2]; //회의 수에 따른 시작시간, 끝나는 시간
		
		for(int i=0; i<N; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(st.nextToken()); //[0]: 시작시간
			time[i][1] = Integer.parseInt(st.nextToken());//[1] : 끝나는시간
		}
		
		//2차원배열 두 번째 요소기준으로 오름차순
    //끝나는 시간을 기준으로 다음 시작시간이 끝나는 시간보다 크거나 같아야 한다.
		Arrays.sort(time,(o1, o2) -> { // time배열의 두 인자를 선언
			if(o1[1]==o2[1]) { //두 인자의 2번째 요소가 같으면
				return o1[0] - o2[0]; //1번째 요소를 비교하여 정렬한다.
			} else {//같지않다면
				return o1[1] - o2[1]; //2번째 요소를 비교하여 정렬한다.
			}
		});

			int pre_time = time[0][1]; //이전 끝난 시간
			int count = 1; //최대 회의 개수
			
			for(int i=1; i<N; i++) {
				if(pre_time<=time[i][0]) { //이전 끝난시간보다 다음시간이 크거나 같으면
					pre_time = time[i][1]; //이전시간 = 다음 끝나는 시간
					count++; //최대 회의 개수 1증가
				}
			}
			
		
		System.out.println(count); //출력
		
	}
}
