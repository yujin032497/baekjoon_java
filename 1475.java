// 2022-07-20
// 방 번호

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static String[] nums = {"0","1", "2", "3", "4", "5", "6", "7", "8", "9"}; //방번호 목록
	
	public static void main(String args[]) throws IOException {
		int[] sets = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}; //각 숫자 개수 배열
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine(); //입력한 숫자
		
		int idx = 0, set_cnt = 1; //입력한 숫자에 대한 인덱스(위치), 0~9까지 사용한 세트
		int i = 0;
		
		while(i<N.length()) {
			
			String n = Character.toString(N.charAt(i)); //입력한 숫자들 중 한 글자 추출
			
			if(n.equals("6") || n.equals("9")) { //6,9 숫자만 따로 (6과 9는 서로 교환 가능)
				idx = Arrays.asList(nums).indexOf("6"); //6먼저 비교
				if(sets[idx]==0) { //현재 세트에 6숫자 개수가 없으면
					idx = Arrays.asList(nums).indexOf("9"); // 9비교
				}
			} else {//1, 2, 3, 4, 5, 7, 8 숫자 비교
				idx = Arrays.asList(nums).indexOf(n);
			}
			
			if(sets[idx] == 0) { //세트에 숫자 갯수가 없다면
				set_cnt++; //세트 개수 +1
				for(int j=0; j<nums.length; j++) {
					sets[j]+=1; //각 숫자들 개수 +1
				}
			} else { //세트에 숫자 갯수가 있다면
				sets[idx] -=1; //해당 숫자에서 가지고 있는 갯수 -1
				i++;
			}
		}
		System.out.print(set_cnt); //몇 개의 세트를 사용했는지 
	}

}
