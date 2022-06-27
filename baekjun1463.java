// 백준 1463     bottom - up   반복문
import java.util.Scanner;
public class baekjun1463 {
    static int d[];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int dp[] = new int[number+1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= number; i++){
            dp[i] = dp[i-1] + 1;
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
        }
        System.out.println(dp[number]);




    }
}
