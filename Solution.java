import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'solve' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER d
     *  2. INTEGER p
     */

   static int solve(int D, int P) {
        if (D < 0) {
            return 0;
        }

        if (P == 0) {
            if (D == 0) {
                return 1;
            } else {
                return 4;
            }
        }

        int result = 0;
        for (int a = 1; a * a <= Math.abs(P); a++) {
            if (P % a == 0) {
                int b = Math.abs(P / a);

                result += search(a, b, P, D);
                if (a != b) {
                    result += search(b, a, P, D);
                }
            }
        }
        return result;
    }

    static int search(int x, int y, int P, int D) {
        int result = 0;
        if (P > 0) {
            if (check(x, y, D)) {
                result++;
            }
            if (check(-x, -y, D)) {
                result++;
            }
        } else {
            if (check(-x, y, D)) {
                result++;
            }
            if (check(x, -y, D)) {
                result++;
            }
        }
        return result;
    }

    static boolean check(int A, int B, int D) {
        return Math.abs(A - B) == D;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int d = Integer.parseInt(firstMultipleInput[0]);

            int p = Integer.parseInt(firstMultipleInput[1]);

            int result = Result.solve(d, p);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
