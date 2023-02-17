import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int sum = 0;

        for (int i = 0; i < 5; i++) {
            int a = scan.nextInt();
            if(a < 40) {
                a = 40;
            }
            sum += a;
        }
        System.out.println(sum / 5);

    }
}
