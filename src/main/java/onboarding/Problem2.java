package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        for(int i=0; i<cryptogram.length(); i++){
            if(i<cryptogram.length()-1){
                char a = cryptogram.charAt(i);
                char b = cryptogram.charAt(i+1);
                if(a==b){
                    if(i==0){
                        if(cryptogram.length()==2){
                            cryptogram="";
                            break;
                        }
                        cryptogram= cryptogram.substring(i+2);
                    }
                    else
                        cryptogram= cryptogram.substring(0,i) + cryptogram.substring(i+2);
                    i=-1;
                }
            }
        }
//        System.out.println("문제 2 : "+cryptogram);
        return cryptogram;
    }
}
