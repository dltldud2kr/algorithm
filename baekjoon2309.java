import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int sum = 0 ;
        int a;
        int b;
        List<Integer> list = new ArrayList();
        for (int i = 0; i < 9; i++) {
            list.add(scan.nextInt());
            sum += list.get(i);
        }   // 140

        loopOut:
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(i != j){
                    int sum2 = sum;
                    sum2 -= list.get(i) + list.get(j);

                    if(sum2 == 100){
                        a = list.get(i);
                        b = list.get(j);
                        list.remove(Integer.valueOf(a));
                        list.remove(Integer.valueOf(b));

                        break loopOut;

                    }
                }
            }
        }

        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
