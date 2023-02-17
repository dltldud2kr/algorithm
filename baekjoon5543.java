import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        int[] list = new int[5];
        int minResult = 10000000;
        int result = 0;

        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            list[i] = scan.nextInt();
        }

        for (int i = 3; i <= 4; i++) {
            for (int j = 0; j < 3; j++) {
                result = list[j] + list[i] - 50;
                if (result < minResult) {
                    minResult = result;
                }
            }
        }
        System.out.println(minResult);
    }
}
