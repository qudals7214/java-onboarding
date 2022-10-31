package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiResult =result(pobi);
        System.out.println("포비 : " + pobiResult);
        if(pobiResult==-1)
            return -1;

        int crongResult =result(crong);
        System.out.println("크롱 : " + crongResult);
        if(crongResult==-1)
            return -1;


        if(pobiResult==crongResult)
            answer=0;
        else if(pobiResult>crongResult)
            answer=1;
        else
            answer=2;

        return answer;
    }

    private static int result(List<Integer> input){
        int left = input.get(0);
        int right = input.get(1);

        if(right-left > 1)
            return -1;
        left = check(input.get(0));
        right = check(input.get(1));

        if(right>left)
            left=right;

        return left;
    }

    private static int check(int a){
        int hun = a/100;
        int ten = (a-hun*100)/10;
        int one = a%10;

        int max = hun+ten+one;
        int y = hun*ten*one;
        if(hun==0)
            y=ten*one;


        if(y>max)
            max=y;

        return max;
    }
}