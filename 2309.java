// 2022-07-07
// 일곱 난쟁이

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class backjoon2309 {
	
	public static void main(String args[]) throws IOException {
		int i, j, sum = 0;
		int [] nums = new int[9];
		int not1=0, not2=0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(i=0; i<9; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			sum += nums[i];
		}
		Arrays.sort(nums);
		
		
		for(i=0; i<nums.length; i++) {
			for (j=i+1; j<nums.length; j++) {
				if(sum-nums[i]-nums[j]==100) {
					not1=i; //아홉 난쟁이 키를 합한 값의 두 난쟁이 키를 뺐을 경우 100이 되는 경우
					not2=j;
				}
			}
		}
		
		for(i=0; i<nums.length; i++) {
			if (i==not1 || i==not2) continue; // 두 난쟁이키에 해당하는 idx는 넘기기
			System.out.println(nums[i]);
		}
		
	}
}
