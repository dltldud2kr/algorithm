import java.util.Calendar;
import java.util.Scanner;
public class calendarPj {

    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("[달력 출력 프로그램]");
        System.out.print("달력의 년도를 입력해 주세요.(yyyy):");
        int year = sc.nextInt();
        System.out.print("달력의 월을 입력해 주세요.(mm):");
        int month = sc.nextInt();

        Calendar cd = Calendar.getInstance();           // Calendar 객체 생성
        cd.set(year,month -1, 1, 0 ,0); //1월이 0으로 시작하기 때문에 받은 값에서 1을 뺀다.
        //1일은 1로 시작.
        //입력한 달의 요일 구하기
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK);   // ( 일 : 1, 월 : 2, 화 : 3, ...  토 : 7)

        cd.add(Calendar.MONTH, 1);
        cd.add(Calendar.DATE, -1);
        int lastDay = cd.get(Calendar.DATE);            //입력받은 년도의 달의 마지막 일을 lastDay에 저장.

        System.out.printf("[%d년 %02d월]\n",year,month);
        System.out.println("일\t월\t화\t수\t목\t금\t토");

        for (int i = 1; i < dayOfWeek; i++) {
            System.out.print("\t");
        }
        int day = 1;
        for (int j = 0; j < lastDay; j++){

            System.out.printf("%02d  ",day );
            if((dayOfWeek + day -1) % 7 == 0){             // 일주일마다 다음 행으로 넘어가기 위해 DAY_OF_WEEK 와 day의 합이 7일때
                System.out.println();                      // 줄바꿈처리 해준다.

            }
            ++day;
        }
    }
}