import java.util.Scanner;

public class baekjoon1924 {

    public static void main(String[] args){
        //인덱스[0]을 0으로 넣은 이유
        // 1월1일이 월요일이니 , 2월 1일의 경우 31 + 1 = 32  1월 5일의 경우 5 >> 일수를 구하기위해 지정
        int []daysInMonth = {0, 31, 28, 31 ,30 ,31 ,30 ,31 , 31 ,30, 31 , 30 ,31};

        String [] dayOfWeek = { "SUN","MON", "TUE", "WED", "THU", "FRI", "SAT"};
        
        Scanner scan = new Scanner(System.in);
        int month = scan.nextInt();
        int day = scan.nextInt();
        int sum= 0;


        for (int i = 0; i < month; i++) {
            sum += daysInMonth[i];          //달마다 일 수를 전부 더해서 SUM에 넣는다.
        }
        sum+= day;
        int res = sum % 7;                  //요일을 구하기위해 SUM에 7의 나머지를 구한다.

        System.out.println(dayOfWeek[res]);


    }
}
