import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // N행
		int M = Integer.parseInt(st.nextToken()); // M열
		
		char[][] map = new char [N][M]; // 체스판
		
    // 체스판 그리기
		for(int i=0; i<N; i++) {
			String str = in.readLine();
			for(int j=0; j<M; j++) {
				
				map[i][j] = str.charAt(j);
			}
		}
		
    /*8*8배열 초기화*/
		char color1 = 'W', color2 = 'B'; // color1 : 처음 돌이 흰 색일때, color2 : 처음돌이 검은 색일 때
		int tmp1 = 0, tmp2 = 0, min_tmp = 0; // tmp1 : 처음 돌이 흰 색일 때 색 변화 시 카운트 +1
                                         // tmp2 : 처음 돌이 검은 색일 때 색 변화 시 카운트 +1
                                         // min_tmp : 두 가지의 카운트 중 작은 카운트
		
    /* 체스판 탐색*/
		int min = Integer.MAX_VALUE;
		for(int i=0; i<N-7; i++) {
			for(int j=0; j<M-7; j++) {
        /* 8*8배열 범위 바뀔 시 초기화*/
				color1 = 'W';
				color2 = 'B';
				tmp1 = 0;
				tmp2 = 0;
        
        /* 8*8배열 탐색*/
				for(int k=i; k<i+8; k++) {
					for(int l=j; l<j+8; l++) {
            
            //처음 돌이 흰색일 때
						if(color1 != map[k][l]) {
							tmp1+=1;
						}
            
						if(l!=j+7) { // 열의 끝자리 돌 = 처음 다음 행의 처음 돌
							if(color1=='W') color1 = 'B';
							else color1 = 'W';
						}
						
            //처음 돌이 검은색일 때
						if(color2 != map[k][l]) {
							tmp2+=1;
						}
            
						if(l!=j+7) { // 열의 끝자리 돌 = 처음 다음행의 돌
							if(color2=='B') color2 = 'W';
							else color2 = 'B';
						}
					}
					
				}
        
        // 두 가지 경우 중 카운터가 작은 거 비교
				min_tmp = Math.min(tmp1, tmp2);
        
        // 8*8배열 탐색 시 가장 작은 카운터 비교
				if(min>min_tmp) min = min_tmp;
			}
		}
    
    /*출력*/
		System.out.print(min);
	}
}
