// 2022-07-18
// 셀프 넘버

public class Main {
	
	static int [] N = new int [10001]; //셀프넘버 10,000자리 생성

	public static void main(String[] args) {

		String s_num; //문자열인 숫자
		int i_num; //셀프넘버 아닌 숫자 = 원래숫자 + 각 자리수의 숫자들
		
		for(int i=0; i<N.length; i++) {
			
			s_num = Integer.toString(i); 정수형인 숫자를 문자열로 형변환
			i_num = i; //셀프넘버 아닌 숫자 = 원래숫자
			if(s_num.length()==1) { //1, 3, 5, 7, 9와 같이 한 자리수인 경우
				
				i_num += Integer.parseInt(s_num); //셀프넘버 아닌 숫자 = 셀프넘버 아닌 숫자 + 각 자리수의 숫자들
				N[i_num] = 1; //셀프넘버 아닌 숫자는 해당 인덱스에 1 할당
				
			} else { //여러 자리수의 경우
				
				for(int j=0; j<s_num.length(); j++) //문자열의 숫자 길이만큼 반복
				{
					
					i_num += Integer.parseInt(s_num.valueOf(s_num.charAt(j)));//각 자리의 숫자들을 더한다.
					
				}
				
				if(i_num <= 10000) N[i_num] = 1; //10000보다 작거나 같으면 원하는 범위값내이다.
                                         			 //해당 인덱스에 1 할당
			}
			
		}
		
		for(int i=1; i<N.length; i++) {
			
			if(N[i]==0) System.out.println(i); //값이 0인 경우 = 셀프넘버
			
		}
	}
}
