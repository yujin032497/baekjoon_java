// 2022-08-11
// 단어 정렬
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String args[]) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<String>[] list = new ArrayList[51]; //문자열이 길이에 따라 단어 넣기
		
		int N = Integer.parseInt(in.readLine());
		String word = ""; //단어
		
		for(int i=0; i<list.length; i++) {
			list[i] = new ArrayList<String>(); //초기화
		}
		
		for(int i=0; i<N; i++) {
			word = in.readLine();
			if(list[word.length()].contains(word)) continue; // 똑같은 단어가 있으면 넘김
			list[word.length()].add(word); //단어 넣기
		}
		
		for(int i=0; i<list.length; i++) {
			Collections.sort(list[i]); // 길이가 같은 단어는 오름차순 정렬
		}
		
    /*출력*/
		for(int i=0; i<list.length; i++) {
			for(int j=0; j<list[i].size(); j++) {
				System.out.println(list[i].get(j));
			}
		}
		
	}
}
