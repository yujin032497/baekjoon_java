// 2022-08-19
// 비밀번호 찾기

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashMap<String, String> map = new HashMap<>(); // 해시맵을 이용하여
		String[] split = in.readLine().split(" ");
		
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);
		
		for(int i=0; i<N; i++) {
			split = in.readLine().split(" ");
			String address = split[0];
			String pass = split[1];
			
			map.put(address, pass);
			
		}
		
		for(int i=0; i<M; i++) {
			String find = in.readLine();
			sb.append(map.get(find)).append("\n"); // key를 통해 value값 찾기
		}
		System.out.println(sb);
	}
}
