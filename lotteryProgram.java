import java.util.Random;
import java.util.Scanner;

public class lotteryProgram {

    //                  로또 당첨번호 생성기
    public int[] lotteryWinningNumber(){
        Random rand = new Random();
        int [] lotteryWinningNumber = new int[6];
        for (int i = 0; i < lotteryWinningNumber.length; i++) {
            lotteryWinningNumber[i] = rand.nextInt(45) + 1;

            //중복되는 번호가 나오면 다른 값을 넣기위해 반복문을 다시 실행한다.
            for (int j = 0; j < i; j++) {
                if (lotteryWinningNumber[i] == lotteryWinningNumber[j]) {
                    i--;
                    break;
                }
            }
        }
        return lotteryWinningNumber;
    }

    //                  내 로또 번호 생성기
    public int[][] myLotteryNumber(int numberOfLotteryPurchases){
        Random rand = new Random();
        int[][] lotteryNum = new int[numberOfLotteryPurchases][6];
        for (int i = 0; i < numberOfLotteryPurchases; i++) {


            for (int j = 0; j < 6; j++) {
                lotteryNum[i][j] = rand.nextInt(45) + 1;

                //중복되는 번호가 나오면 다른 값을 넣기위해 반복문을 다시 실행한다.
                for(int k=0; k<j; k++) {
                    if(lotteryNum[i][j] == lotteryNum[i][k]) {
                        j--;
                        break;
                    }
                }
            }

        }
        return lotteryNum;
    }

    public void lotteryWinningNumberPrintInfo(int[]wN){
        System.out.println("[로또 발표]");
        System.out.print("\t");
        for(int i = 0; i < wN.length; i++){
            if(i== wN.length -1) {
                System.out.printf("%02d", wN[i]);
            }
            else{
                System.out.printf("%02d,",wN[i]);
            }
        }
        System.out.println("\n");
    }

    public void myLotteryPrintInfo(int numberOfLotteryPurchases, char[] alphabat, int[][]lN){
        for (int i = 0; i < numberOfLotteryPurchases; i++) {
            alphabat[i] = (char)('A' + i);          // 로또 구입 개수대로 A부터 Z까지 출력된다.
            System.out.print(alphabat[i] + "\t");
            for (int j = 0; j < 6; j++) {
                if(j==5) {
                    System.out.printf("%02d", lN[i][j]);
                }
                else {
                    System.out.printf("%02d,", lN[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println();
    }



    public static void main(String[] args) {


        Random rand = new Random();

        int correctCnt = 0;
        Scanner sc = new Scanner(System.in);

        lotteryProgram lP = new lotteryProgram();
        char[] alphabat = new char[26];             //알파벳 갯수대로 알파벳 배열 생성

        System.out.println("[로또 당첨 프로그램]\n");
        System.out.print("로또 개수를 입력해 주세요.(숫자 1 ~ 10):");
        int numberOfLotteryPurchases = sc.nextInt();

        //          내 로또번호 생성기
        int [][] lN = lP.myLotteryNumber(numberOfLotteryPurchases);

        //          로또 당첨번호 생성기.
        int [] wN = lP.lotteryWinningNumber();

        //          내 로또번호  출력
        lP.myLotteryPrintInfo(numberOfLotteryPurchases,alphabat,lN);


        //          로또 당첨번호 발표
        lP.lotteryWinningNumberPrintInfo(wN);

        //          내 로또 일치 개수
        System.out.println("[내 로또 결과]");
        for(int i = 0; i < numberOfLotteryPurchases; i++){
            alphabat[i] = (char) ('A' + i);
            System.out.print(alphabat[i]+"\t");
            for (int j = 0; j < 6; j++) {

                if(j==5) {
                    System.out.printf("%02d", lN[i][j]);
                }
                else{
                    System.out.printf("%02d,",lN[i][j]);
                }
            }


            //  로또당첨번호와 내 로또번호의 일치 수를 찾는다.
            for (int j = 0; j < wN.length; j++) {
                for (int k = 0; k < 6; k++) {
                    if(wN[j] == lN[i][k]){
                        correctCnt++;
                    }else{
                        continue;
                    }
                }
            }
            System.out.printf(" => %d개 일치\n",correctCnt);

            correctCnt =0;

        }
    }
}