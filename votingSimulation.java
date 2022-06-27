import java.util.Random;
public class votingSimulation {
    static int totalCount = 10000;          // 총 투표 수

    // 후보들의 투표 수를 비교하여 당선자 이름을 반환시킴.
    public String electedPeople(int one,int two,int three, int four){
        int max = one;
        String electedPeople = "이재명";
        if (two > max){
            max = two;
            electedPeople = "윤석열";
        }
        else if (three > max){
            max = three;
            electedPeople = "심상정";
        }
        else if (four > max){
            max = four;
            electedPeople = "안철수";
        }
        return electedPeople;
    }


    // 매개변수로 기호 1,2,3,4 투표수 , 전체 투표수 , 투표한 후보 이름을 받음.
    public void printInfo(int one, int two, int three, int four, int voteCount, String str){
        System.out.printf("[투표진행율]: %.2f%%, %d명 투표 => %s\n",(double)voteCount / totalCount * 100 , voteCount ,str);
        System.out.printf("[기호 1] 이재명: %05.2f%%, (투표수: %d)\n",(double)one/totalCount * 100,one);
        System.out.printf("[기호 2] 윤석열: %05.2f%%, (투표수: %d)\n",(double)two/totalCount * 100,two);
        System.out.printf("[기호 3] 심상정: %05.2f%%, (투표수: %d)\n",(double)three/totalCount * 100,three);
        System.out.printf("[기호 4] 안철수: %05.2f%%, (투표수: %d)\n",(double)four/totalCount * 100,four);


    }


    public static void main(String[] args){
        int recentVote = 0;
        int one =0;
        int two = 0;
        int three = 0;
        int four = 0;
        int voteCount = 0;
        String str = "";

        Random rand = new Random();

        votingSimulation vS = new votingSimulation();

        for (int i = 1; i <= totalCount; i++) {
            int voteResult = rand.nextInt(4) + 1;       // 1 ~ 4 중 하나를 랜덤으로 받는다.
            recentVote = voteResult;
            if (voteResult == 1) {
                one += 1;
                str = "이재명";
            } else if (voteResult == 2) {
                two += 1;
                str = "윤석열";
            } else if (voteResult == 3) {
                three += 1;
                str = "심상정";
            } else {
                four += 1;
                str = "안철수";
            }

            // 마지막 투표 후 동율투표가 확인되면 동율이 안될때까지 마지막 투표를 반복한다.
            if (i == 10000){
                if (one == two || one == three || one == four || two == three || two == four || three == four) {
                    if (recentVote == 1){
                        one --;
                    } else if (recentVote == 2){
                        two --;
                    } else if (recentVote == 3){
                        three --;
                    } else {
                        four --;
                    }
                    i--;
                    voteCount --;
                }
            }

            voteCount += 1;
            vS.printInfo(one,two,three,four,voteCount,str);

        }
        System.out.print("[투표결과] 당선인: " + vS.electedPeople(one,two,three,four));


    }
}