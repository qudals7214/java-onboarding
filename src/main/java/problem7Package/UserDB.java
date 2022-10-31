package problem7Package;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDB {
    public static Map<String , User> userList = new HashMap<>();

    public void makeUserList(List<List<String>> friends, List<String> visitors){
//        Map<String,User> user = new HashMap<>();
        for(String a : visitors){
            User temp = new User(a);
            userList.put(a , temp);
        }
        for(List<String> a : friends){
            if(userList.get(a.get(0))==null){
                User temp = new User(a.get(0));
                userList.put(a.get(0),temp);
            }
            if(userList.get(a.get(1))==null){
                User temp = new User(a.get(1));
                userList.put(a.get(1),temp);
            }
        }

        for(List<String> a : friends) {
            User temp1 = userList.get(a.get(0));
            User temp2 = userList.get(a.get(1));
            temp1.friend(a.get(1));
            temp2.friend(a.get(0));
//            System.out.println(a.get(0)+"의 친구 목록 : "+temp1.friends);
        }


    }
}
