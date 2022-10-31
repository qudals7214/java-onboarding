package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for(int i =0; i<word.length(); i++){
            char a = word.charAt(i);
            if((a>=97 && a<=122) || (a>=65 && a<=90)){
                int reverse = 0;
                if(a<=90){
                    reverse=a-65;
                    reverse=90-reverse;
                }
                else{
                    reverse=a-97;
                    reverse=122-reverse;
                }
                a= (char) reverse;
            }
            answer+=a;
        }
        System.out.println("청개구리 : "+answer);
        return answer;
    }
}
