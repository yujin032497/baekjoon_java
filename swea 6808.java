package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int[] numbers = new int [9];
	static int[] kyuCards = new int[9];
	static int[] inCards = new int [9];
	static int kyuCnt = 0;
	static int inCnt = 0;
	
	public static void main(String args[]) throws Exception {
		
		System.setIn(new FileInputStream("s_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			kyuCards = new int[9];
			inCards = new int[9];
			
			for(int i=0; i<9; i++) {
				kyuCards[i] = Integer.parseInt(st.nextToken());
			}
			
			int idx=0;
			for(int i=0; i<18; i++) {
				if(Arrays.asList(kyuCards).contains(i)) continue;
				else {
					inCards[idx]=i;
					idx++;
				}
			}
			
			comb(0,0);
			sb.append(kyuCnt+" "+inCnt).append("\n");
		}
	}

	private static void comb(int start, int cnt) {
		
		if(cnt == 9) {
			int inScore = 0;
			int kyuScore = 0;
			for(int i=0; i<9; i++) {
				if(kyuCards[i] < inCards[i]) {
					inScore = kyuCards[i] + inCards[i];
				} else {
					kyuScore = kyuCards[i] + inCards[i];
				}
			}
			
			if(inScore > kyuScore) {
				inCnt++;
			} else if(inScore < kyuScore) {
				kyuCnt++;
			}
		}
		
		for(int i=0; i<9; i++) {
		
			numbers[cnt] = inCards[i];
			comb(cnt + 1, i+1);
		}
		
	}
}
