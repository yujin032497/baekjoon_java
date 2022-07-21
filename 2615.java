// 2022-07-22
// 오목

import java.util.Scanner;

public class Main {
	
	//순방향,역방향 => 총 4세트
	static int[][] dx = {{1,-1},{1,-1},{1,-1},{0,0}};
	static int[][] dy = {{1,-1},{0,0},{-1,1},{1,-1}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] map = new int [19][19];
		int color = 0; //1: 검은 바둑알, 2: 흰 바둑알
		int x1 = 0, y1 = 0; //시작좌표
		int x = 0, y = 0; //좌표
		int ans_x = 19, ans_y = 19; //가장 왼쪽에 잇는 바둑돌 좌표(초기화는 19로 가장 큰 수로 잡는다.)
		int count = 0; //바둑알 개수
		boolean b_winner = false, w_winner = false; //검은 바둑알 승리, 흰 바둑알 승리
		int b_x = 0, b_y = 0, w_x = 0, w_y = 0; //검은 바둑알 좌표, 흰 바둑알 좌표 ((1,1)에 가장 가까운 좌표 출력을 위함.)
		
		//바둑판
		for(int i=0; i<19; i++) {
			for(int j=0; j<19; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		//오목 우승자 찾기
		search:
		for(int i=0; i<19; i++) {
			for(int j=0; j<19; j++) {
				
				//검은 바둑알, 흰 바둑알 찾기
				if(map[i][j] == 1 || map[i][j] == 2) {
					
					color = map[i][j];
					x1 = i;
					y1 = j;
					
					int nx = 0, ny = 0;
					
					//4가지 방향종류를 통해 바둑알 5개 찾기
					for(int k=0; k<4; k++) {
						
						count = 1;
						ans_x = x1;
						ans_y = y1;
						
						for(int l=0; l<2; l++) { //순방향, 역방향
							x = x1;
							y = y1;	
							while(true) {
								
								nx = x+dx[k][l];
								ny = y+dy[k][l];

								//배열 범위 밖이 아니면
								if(nx < 0 || ny < 0 || nx >= 19 || ny >= 19) break;

								if(map[nx][ny] != color) break; //탐색한 바둑알과 색이 다르면
								
                //탐색한 바둑알과 색이 
								x = nx;
								y = ny;
								count++;
								
                //(1,1) 좌표가 가장 가까운 순서는 1. 가장 왼쪽 2. 가장 위쪽
								if(ans_y > y) { //가장 왼쪽에 있는지 먼저 확인
									
									ans_y = y;
								}
									
								if(ans_y == y && ans_x > x) //y좌표가 같고(이미 가장 왼쪽), 가장 위쪽에 있는지 확인
								{
									ans_x = x;
								}
								
							}
						}
						
						if(count==5) { //바둑돌 카운트가 5이면
							if(color == 1) { //탐색한 바둑알이 검은 바둑알이면
								b_winner = true;
								b_x = ans_x;
								b_y = ans_y;
								break;
							}else if(color == 2) {//탐색한 바둑알이 흰 
								w_winner = true;
								w_x = ans_x;
								w_y = ans_y;
								break;
							}
						}
						
					}
				}
			}
		}
		
		if(b_winner == w_winner) { //검은 바둑 알, 흰 바둑 알 둘 다 바둑알 5개라서 비겼거나
                               //검은 바둑 알, 흰 바둑 알 둘 다 바둑알 5개 아닐경우
			System.out.println(0); //0출력
		} else {
			if(b_winner) { //검은 바둑알 승리일 경우
				System.out.println(1);
				System.out.printf("%d %d", b_x+1, b_y+1);
			}
			else if(w_winner) { //
				System.out.println(2);
				System.out.printf("%d %d", w_x+1, w_y+1);
			}
		}
	}
}
