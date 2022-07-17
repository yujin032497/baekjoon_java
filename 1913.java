// 2022-07-18
// 달팽이

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int [][] map; //달팽이 표(N*N)
	static int n, nx, ny; //찾을 숫자, 찾을 숫자의 x좌표, 찾을 숫자 y좌표([x,y])
	static int N; //N*N배열 생성을 위한 숫자
	
  //[x,y]
  //방향을 위한 x좌표, y좌표 
	static int [] dx = {-1, 0, 1, 0; //위쪽,오른쪽,아랫쪽,왼쪽
 	static int [] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {

		int x, y; //현재 x좌표, y좌표
		int idx = 0, num = 1; //방향 인덱스번호, 달팽이표에 넣을 숫자: 초기화 1(시작숫자)
		StringBuilder sb = new StringBuilder(); //문자열로 출력하기 위함
                                            //String str로 계속 이어붙일 시 지웠다가 새로 쓰므로 가비지컬렉션이 늘어남(메모리초과발생)
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); 
		n = Integer.parseInt(br.readLine());
		
		map = new int [N][N];
		
		x = N/2; //N*N배열의 한가운데 x좌표
		y = N/2; //N*N배열의 한가운데 y좌표
		
		map[x][y] = num; //N*N배열의 한가운데 1을 넣는다.
		
		while(true) { //무한루프
			
			x += dx[idx];
			y += dy[idx];
			
			if(x<0 | y<0 | x>=N | y>=N) break; //0,0배열에서 벗어나거나 N번째이거나 벗어날 시 루프 종료(배열인덱스는 N-1까지)
			
			if(idx!=3) { //방향인덱스 3이 아니면(방향배열 인덱스 : 0,1,2,3)
				if(map[x+dx[idx+1]][y+dy[idx+1]]==0) idx++; //다음 방향에서 달팽이표의 칸에 0이면 방향인덱스+1 :방향변경
			} else {
				if(map[x+dx[0]][y+dy[0]]==0) idx=0; //방향인덱스가 3일경우 다시 처음 방향인덱스 0에서 달팽이표의 칸에 0이면 방향인덱스는 0: 다시 위쪽방향으로!
			}
			
			num++; //숫자 +1증가
			map[x][y] = num; //달팽이표에 숫자 입력
		}
		
    //달팽이표 출력
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(n==map[i][j]) { //찾을 숫자를 발견하면
					nx = i+1; //찾을 숫자의 x좌표
					ny = j+1; //찾을 숫자의 y좌표
				}
				sb.append(map[i][j]+" "); //숫자 이어붙이기
			}
			sb.append("\n"); //한줄 다 이어붙이면 줄바꿈
		}
		sb.append(nx+ " " +ny); //x좌표, y좌표 이어붙이기
		System.out.println(sb.toString()); //
		
	}

}
