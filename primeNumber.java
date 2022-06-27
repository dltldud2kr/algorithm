public class primeNumber {
    public int primeNumber(int n) {
        int answer = 0;
        int num = 2;
        while(num <= n){
            for (int i = 2; i <= num; i++){
                if (num % i == 0 && i != num){
                    break;
                }
                if (num % i == 0 && i == num) {
                    answer ++;
                }
            }
            num++;
        }
        return answer;
    }

    public static void main(String[] args){

        primeNumber pN = new primeNumber();
        System.out.println("소수의 개수 : " + pN.primeNumber(15));
    }
}
