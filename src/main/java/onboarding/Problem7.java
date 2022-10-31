package onboarding;

import problem7Package.User;
import problem7Package.UserDB;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        UserDB userDB = new UserDB();
        userDB.makeUserList(friends, visitors);



//        mrko.setRecomFriends();
//        mrko.setRecomVisit(visitors);
//        System.out.println(mrko.name+"의 친구 목록 : "+mrko.friends);
//        System.out.println(mrko.name+"의 추천 목록 : "+mrko.recommendationList);

        Iterator key = UserDB.userList.keySet().iterator();

        while (key.hasNext()){
//            System.out.println();
            User temp = UserDB.userList.get(key.next());
//            System.out.println(temp.name+"의 친구 목록 : "+temp.friends);
            temp.setRecomFriends();
            temp.setRecomVisit(visitors);
            temp.getRecommendationList();
//            temp.soutRecom();
        }

        answer=UserDB.userList.get(user).getRecommendationList();
        return answer;
    }
}
