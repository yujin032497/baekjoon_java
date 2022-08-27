// 2022-08-27
// 색종이 붙이기

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static class Node {
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[][] map = new int [10][10];
	static boolean[][] visit = new boolean[10][10];
	static int[] paper = {0,5,5,5,5,5};
	static int count = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<10; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=0; j<10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		simulate();
		if(count==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(count);
		
	}
	private static void simulate() {
		
		Node temp = findStart();
		if(temp.x == -1 && temp.y==-1) {
			countPaper();
			return;
		}
		
		int nx = temp.x;
		int ny = temp.y;
		
		for(int k=5; k>=1; k--) {
			if(paper[k]>0) {
				paper[k]-=1;
				if(isInboundary(nx,ny,k)) {
					fill(nx,ny,k,true);
					simulate();
					fill(nx,ny,k,false);
				}
				paper[k]+=1;
			}
		}
	}
	private static void countPaper() {
		int min = 0;
		for(int i=1; i<=5; i++) {
			min+= (5-paper[i]);
		}
		if(count>min) count = min;
		
	}
	private static void fill(int nx, int ny, int k, boolean b) {
		for(int i=0; i<k; i++) {
			for(int j=0; j<k; j++) {
				visit[nx+i][ny+j] = b;
			}
		}
		
	}
	private static boolean isInboundary(int nx, int ny, int size) {
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				if(nx+i>=10 || ny+j>=10 || map[nx+i][ny+j]==0 || visit[nx+i][ny+j]) {
					return false;
				}
			}
		}
		return true;
	}
	private static Node findStart() {
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				if(map[i][j] == 1 && !visit[i][j]) return new Node(i,j);
			}
		}
		return new Node(-1,-1);
	}
}


