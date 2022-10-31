package problem7Package;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Recommendation {
    String name;
    int score;
    int visit;
    Map<String , String> friendsKnow= new HashMap<>();

    public int getScore(){
        score= visit*1 + friendsKnow.size()*10;
//        score= visit*1;
//        if(friendsKnow.containsKey())
//            score+=friendsKnow.size()*10;
        return score;
    }

    public void checkFriendsKnow(List<String> friends){
        Iterator key = friendsKnow.keySet().iterator();
            System.out.println("함께 아는 친구");
        while (key.hasNext()){
            String name = key.next().toString();
            System.out.println(friendsKnow.get(name));
        }
    }



}
