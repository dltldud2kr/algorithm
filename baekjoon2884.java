import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int h = scan.nextInt();
        int m = scan.nextInt();

        if(m - 45 < 0) {
            h=  h-1;
            if(h < 0){
                h = 24 + h;
            }
            m = (m - 45) + 60;
        } else {
            m = m - 45;
        }

        System.out.println(h + " " + m);
    }
}
