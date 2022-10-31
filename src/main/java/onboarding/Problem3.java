package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int n = 0;
        while(n<=number){
            if(n%10 == 3 || n%10 == 6 || n%10 == 9)
                answer++;
            if(n/10 ==3 || n/10 == 6 || n/10 ==9)
                answer++;
            if(n/100 ==3 || n/100 == 6 || n/100 ==9)
                answer++;
            if(n/1000 ==3 || n/1000 == 6 || n/1000 ==9)
                answer++;
            n++;
        }
        return answer;
    }
}
