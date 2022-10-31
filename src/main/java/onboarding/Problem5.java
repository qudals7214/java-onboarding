package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] currency = {50000, 10000, 5000,1000,500,100,50,10,1};

        for (int a : currency){
            answer.add(money/a);
            money-=money/a*a;
            System.out.println("돈 : " + money);
            System.out.println("지폐 : " + answer);
        }

        return answer;
    }
}
