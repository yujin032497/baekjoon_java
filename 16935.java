// 2022-08-10
// 배열 돌리기 3

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // N행
		int M = Integer.parseInt(st.nextToken()); // M열
		int R = Integer.parseInt(st.nextToken()); // 연산의 수
		
		int[][] map = new int [N][M];
		int[][] ans = null;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] num = new int [R]; // 연산의 수 배열
		
		st = new StringTokenizer(in.readLine());
		
		for(int i=0; i<R; i++) {
			num[i] = Integer.parseInt(st.nextToken()); // 연산번호
		}
		
		for(int k=0; k<num.length; k++) {
			
			int x = 0, y = 0;
      
			switch(num[k]) {
          
			case 1: // 상하
				ans = new int [map.length][map[0].length];
				x = map.length-1;
				for(int i=0; i<map.length; i++) {
					for(int j=0; j<map[0].length; j++) {
						ans[x][j] = map[i][j];
					}
					x--;
				}
				break;
			case 2: // 좌우
				ans = new int [map.length][map[0].length];
				
				for(int i=0; i<map.length; i++) {
					y = map[0].length-1;
					for(int j=0; j<map[0].length; j++) {
						ans[i][y] = map[i][j];
						y--;
					}
				}
				break;
			case 3: //90도회전 오른쪽
				x = 0;
				y = 0;
				
				ans = new int[map[0].length][map.length];
				for(int i=0; i<map[0].length; i++) {
					y=0;
					for(int j=map.length-1; j>=0; j--) {
						ans[x][y] = map[j][i];
						y++;
					}
					x++;
				}
				break;
			case 4: //90도회전 왼쪽
				x = 0;
				y = 0;
				
				ans = new int[map[0].length][map.length];
				for(int i=map[0].length-1; i>=0; i--) {
					y=0;
					for(int j=0; j<map.length; j++) {
						ans[x][y] = map[j][i];
						y++;
					}
					x++;
				}
				break;
			case 5: // N/2, M/2 분할 오른쪽
				ans = new int [map.length][map[0].length];
				
				//1번->2번
				x = 0;
				y = map[0].length/2;
				for(int i=0; i<map.length/2; i++) {
					y = map[0].length/2;
					for(int j=0; j<map[0].length/2; j++) {
						ans[x][y] = map[i][j];
						y++;
					}
					x++;
				}
				
				//2번->3번
				x = map.length/2;
				y = map[0].length/2;
				for(int i=0; i<map.length/2; i++) {
					y = map[0].length/2;
					for(int j=map[0].length/2; j<map[0].length; j++) {
						ans[x][y] = map[i][j];
						y++;
					}
					x++;
				}
				
				//3번->4번
				x = map.length/2;
				y = 0;
				for(int i=map.length/2; i<map.length; i++) {
					y=0;
					for(int j=map[0].length/2; j<map[0].length; j++) {
						ans[x][y] = map[i][j];
						y++;
					}
					x++;
				}
				
				//4번->1번
				x = 0;
				y = 0;
				for(int i=map.length/2; i<map.length; i++) {
					y = 0;
					for(int j=0; j<map[0].length/2; j++) {
						ans[x][y] = map[i][j];
						y++;
					}
					x++;
				}
				break;
			case 6: // N/2, M/2 분할 
				//1번->4번
				ans = new int [map.length][map[0].length];
				x = map.length/2;
				y = 0;
				
				for(int i=0; i<map.length/2; i++ ) {
					y = 0;
					for(int j=0; j<map[0].length/2; j++) {
						ans[x][y] = map[i][j];
						y++;
					}
					x++;
				}
				
				//4번->3번
				x = map.length/2;
				for(int i=map.length/2; i<map.length; i++) {
					y = map[0].length/2;
					for(int j=0; j<map[0].length/2; j++) {
						ans[x][y] = map[i][j];
						y++;
					}
					x++;
				}
				
				//3번->2번
				x=0;
				for(int i=map.length/2; i<map.length; i++) {
					y=map[0].length/2;
					for(int j=map[0].length/2; j<map[0].length; j++) {
						ans[x][y] = map[i][j];
						y++;
					}
					x++;
				}
				
				//2번->1번
				x=0;
				for(int i=0; i<map.length/2; i++) {
					y=0;
					for(int j=map[0].length/2; j<map[0].length; j++) {
						ans[x][y] = map[i][j];
						y++;
					}
					x++;
				}
				
				break;
			}
			
      // 정답배열로 넣었던 데이터를 다시 원본 데이터로 교체
			map = ans;
		}
		
    // 출력
		for(int i=0; i<ans.length; i++) {
			for(int j=0; j<ans[i].length; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}
}
