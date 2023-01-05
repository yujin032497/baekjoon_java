// 2023-01-05
// 엄청난 부자2

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger n = in.nextBigInteger(); // 입력 범위 때문에 BigInteger로 받는다.
        BigInteger m = in.nextBigInteger();
        in.close();
        System.out.println(n.divide(m));
        System.out.println(n.remainder(m));

    }
}
