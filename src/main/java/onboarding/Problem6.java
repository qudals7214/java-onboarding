package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
//        List<String> answer = List.of("answer");
        List<String> answer = new ArrayList<>();

        for(int i=0; i<forms.size(); i++){
            for(int j =0; j<forms.get(i).get(1).length(); j++){
                if(j<forms.get(i).get(1).length()-1){
                    String check = forms.get(i).get(1).substring(j,j+2);

                    for(int k = i+1; k<forms.size(); k++){
                        if(forms.get(k).get(1).contains(check)){
                            answer.add(forms.get(k).get(0));
                            answer.add(forms.get(i).get(0));
                        }
                    }
                }
            }
        }
        TreeSet<String> sort = new TreeSet<>(answer);
        answer = new ArrayList<>(sort);
        for(String a : answer){
//            System.out.println(a);
        }
        return answer;
    }
}
