// 2022-08-06
// 트리 순회

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int [] node; //노드
	static int [][] child; //자식노드
	static StringBuilder sb;
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		node = new int [N]; //노드
		child = new int [N][N]; //자식배열
		
		int idx = 0, left = 0, right = 0;
		for(int i=0; i<N; i++) {
			String[] split = in.readLine().split(" ");
			idx = split[0].charAt(0) - 'A';
			
			if(split[1].charAt(0)=='.') left = -1;
			else left = split[1].charAt(0) - 'A';
			
			if(split[2].charAt(0)=='.') right = -1;
			else right = split[2].charAt(0) - 'A';
			
			node[idx] = idx; // 노드
			child[0][idx] = left; // 왼쪽자식
			child[1][idx] = right; // 오른쪽자식
		
		}
		
		preOrder(node[0]);
		sb.append("\n");
		inOrder(node[0]);
		sb.append("\n");
		postOrder(node[0]);
		System.out.print(sb);
	}
	
	// 전위순회
	private static void preOrder(int node) {
		
		sb.append((char) (node+'A'));
		
		if(child[0][node]==-1 && child[1][node] == -1) {
			return;
		}
		
		if(child[0][node]!=-1) {
			preOrder(child[0][node]);
		}
		if(child[1][node]!=-1) {
			preOrder(child[1][node]);
		}
	}
	
	// 중위순회
	private static void inOrder(int node) {
		
		if(child[0][node]==-1) {
			sb.append((char) (node + 'A'));
		}
		
		if(child[0][node]!=-1) {
			inOrder(child[0][node]);
			sb.append((char) (node + 'A'));
		}
		
		if(child[1][node]!=-1) {
			inOrder(child[1][node]);
		}
		
	}
	
	// 후위순회
	private static void postOrder(int node) {
		
		if(child[0][node]!=-1) {
			postOrder(child[0][node]);
		}
		if(child[1][node]!=-1) {
			postOrder(child[1][node]);
		}
		
		sb.append((char) (node + 'A'));
	}

}
