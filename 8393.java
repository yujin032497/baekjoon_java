// 2023-01-04
// 합

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int sum = 0;

        for(int i=1; i<=n; i++) {
            sum+=i;
        }

        System.out.println(sum);
    }
}
