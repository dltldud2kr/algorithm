import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int [] list = new int[5];

        Scanner scan = new Scanner(System.in);

        int onePerPsn = scan.nextInt();
        int party = scan.nextInt();

        int maxResult = onePerPsn * party ;

        for (int i = 0; i < 5; i++) {
            list[i] = scan.nextInt();

            System.out.print( list[i] - maxResult + " ");
        }
    }
}