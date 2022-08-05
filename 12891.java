// 2022-08-05
// 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] check = new int [4]; // 0:'A', 1:'C', 2:'G', 3:'T'
	static int count = 0;
	
	public static void checking(int[] nums) { // 유효개수 확인
		
		if (nums[0] < check[0]) return;
		if (nums[1] < check[1]) return;
		if (nums[2] < check[2]) return;
		if (nums[3] < check[3]) return;
		
		count++; // 유효개수가 다 맞으면 카운트 1증가
	}
	
	public static void add(int[] nums, char ch) { // 슬라이딩을 통해 뒤에 문자 추가 후 개수 +1
		switch (ch) {
		case 'A':
			nums[0]++;
			break;
		case 'C':
			nums[1]++;
			break;
		case 'G':
			nums[2]++;
			break;
		case 'T':
			nums[3]++;
			break;
		}
	}
	
	public static void remove(int[] nums, char ch) { // 슬라이딩을 통해 앞에 문자 제거 후 개수 -1
		switch (ch) {
		case 'A':
			nums[0]--;
			break;
		case 'C':
			nums[1]--;
			break;
		case 'G':
			nums[2]--;
			break;
		case 'T':
			nums[3]--;
			break;
		}
	}
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int s_Len = Integer.parseInt(st.nextToken()); //DNA문자열길이
		int p_Len = Integer.parseInt(st.nextToken()); //비밀번호 부분문자열길이
		
		String str = in.readLine(); //DNA문자열
		

		//부분문자열에 포함되어야 할 최소 개수
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<check.length; i++) {
			check[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] nums = new int [4]; // 유효 글자에 대한 개수 배열
		
		//초기 비밀번호 부분문자열 개수 세기
		for(int i=0; i<p_Len; i++) {
	
			add(nums, str.charAt(i)); //더하기
			
		}
		checking(nums); // 유효검사
		
		//슬라이딩 윈도우로 더하고 빼기
		for(int i=1; i<=s_Len-p_Len; i++) {
		
			remove(nums, str.charAt(i-1)); // 빼기
			add(nums, str.charAt(p_Len+i-1)); // 더하기
			
			checking(nums); // 유효검사
		}
		
		System.out.println(count); //출력
		
	}

}
