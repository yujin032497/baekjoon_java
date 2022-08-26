// 2022-08-27
// 톱니바퀴

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int[][] Gear = new int [5][9];
	static int[] distance;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=1; i<=4; i++) {
			String line = in.readLine();
			for(int j=1; j<=8; j++) {
				Gear[i][j] = line.charAt(j-1)-'0';
			}
		}
		
		int K = Integer.parseInt(in.readLine());
		
		for(int i=0; i<K; i++) {
			String[] split = in.readLine().split(" ");
			int n = Integer.parseInt(split[0]);
			distance = new int [5];
			distance[n] = Integer.parseInt(split[1]);
			
			if(n-1>=1) {
				if(Gear[n][7]!=Gear[n-1][3]) distance[n-1]=-distance[n];
			}
			if(n+1<=4) {
				if(Gear[n][3]!=Gear[n+1][7]) distance[n+1]=-distance[n];
			}
			if(n-2>=1) {
				if(Gear[n-1][7]!=Gear[n-2][3]) distance[n-2]=-distance[n-1];
			}
			if(n+2<=4) {
				if(Gear[n+1][3]!=Gear[n+2][7]) distance[n+2]=-distance[n+1];
			}
			if(n-3>=1) {
				if(Gear[n-2][7]!=Gear[n-3][3]) distance[n-3]=-distance[n-2];
			}
			if(n+3<=4) {
				if(Gear[n+2][3]!=Gear[n+3][7]) distance[n+3]=-distance[n+2];
			}
			
			for(int j=1; j<=4; j++) {
				if(distance[j]==1) { //시계방향
					
					int tmp1 = Gear[j][1];
					int tmp2 = 0;
					for(int k=2; k<=8; k++) {
						tmp2 = Gear[j][k];
						Gear[j][k] = tmp1;
						tmp1 = tmp2;
					}
					Gear[j][1] = tmp1;
					
				} else if (distance[j]==-1) { //시계반대방향
					int tmp1 = Gear[j][8];
					int tmp2 = 0;
					for(int k=7; k>=1; k--) {
						tmp2 = Gear[j][k];
						Gear[j][k] = tmp1;
						tmp1 = tmp2;
					}
					Gear[j][8] = tmp1;
				}
			}
		}
		
		
		int ans = 0;
		if(Gear[1][1]==1) ans+=1;
		if(Gear[2][1]==1) ans+=2;
		if(Gear[3][1]==1) ans+=4;
		if(Gear[4][1]==1) ans+=8;
		System.out.println(ans);
	}

}
