import java.util.Scanner;

public class baekjoon11721 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println();
        String str = scan.nextLine();
        int count = str.length() / 10;
        int index =0;
        int a=  0;
        for (int i = 0; i < count ; i++) {
            System.out.println(str.substring(index,index +10));
            index += 10;
        }
        a = str.length() % 10;
        System.out.println(str.substring(str.length() - a));

    }
}
