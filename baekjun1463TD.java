import java.util.Scanner;

//백준 1463 TOP- BOTTOM  점화식
public class baekjun1463TD{

    public static int d[];
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        d = new int[number+1];
        System.out.println(calculate(number));
    }

    public static int calculate(int number){
        if (number == 1){
            return 0;
        }
        if (d[number] > 0){
            return d[number];
        }
        d[number] = calculate(number-1) + 1;
        if (number%3 == 0) {
            d[number] = Math.min(d[number],calculate(number/3) +1);
        }
        if (number%2 == 0) {
            d[number] = Math.min(d[number],calculate(number/2) +1);
        }
        return d[number];
    }
}