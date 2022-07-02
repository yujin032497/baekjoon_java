// 2022-07-02
// We love kriii

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
 
    public static void main(String[] args) throws IOException {
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	String s1 = "강한친구";
    	String s2 = "대한육군";
    	bw.write(s1+" "+s2+"\n");
    	bw.write(s1+" "+s2+"\n");
    	bw.flush();
    	bw.close();
    }
 
}
