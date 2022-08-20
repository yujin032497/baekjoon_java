// 2022-08-20
// 등수 구하기

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		
		int N = Integer.parseInt(split[0]);
		int taesu = Integer.parseInt(split[1]);
		int rank = Integer.parseInt(split[2]);
		int ans = 0;
		
		ArrayList<Integer> scores = new ArrayList<>();
		ArrayList<Integer> newScores = new ArrayList<>();
		
		if(N==0) ans = 1;
		else {
			
			split = in.readLine().split(" ");
			for(int i=0; i<N; i++) {
				scores.add(Integer.parseInt(split[i]));
				newScores.add(Integer.parseInt(split[i]));
			}
			
			Collections.sort(scores);
			Collections.reverse(scores);

			int tmpRank = scores.lastIndexOf(taesu);
			if(tmpRank+1==rank) ans = -1;
			else {
				newScores.add(taesu);
				Collections.sort(newScores);
				Collections.reverse(newScores);
				tmpRank = newScores.indexOf(taesu);
				if(tmpRank>rank-1) ans = -1;
				else ans = tmpRank+1;
			}
		}
		
		System.out.println(ans);
	}

}
