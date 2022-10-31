package problem7Package;

import java.util.*;

public class User {
    public String name;
    public List<String> friends = new ArrayList<>();
    public Map<String , Recommendation> recommendationList;
    List<Recommendation> recom;
    List<String> result = new ArrayList<>();


    public void soutRecom(){
        System.out.print(name+"의 친구 추천 목록 : [");
        for(Recommendation a : recom){
            System.out.print("이름 : "+a.name+" 점수 : "+a.score+" ");
        }
        System.out.print("]");
        System.out.println();
    }

    public List<String> getRecommendationList(){
        recom=new ArrayList<>();
        List<String> result = new ArrayList<>();
//        recommendationList=new HashMap<>();
        Iterator<String> key = recommendationList.keySet().iterator();

        while(key.hasNext()){
            String keyName = key.next().toString();
            Recommendation recommendation = recommendationList.get(keyName);
            recommendation.getScore();
            recom.add(recommendation);
        }

        for(int i=0; i<friends.size(); i++){
            for(int j =0; j<recom.size(); j++){
                if(recom.get(j).name.equals(friends.get(i)))
                    recom.remove(j);
            }
        }

        Collections.sort(recom,comparator);

        for(int i=0; i<recom.size(); i++){
            if(i==5)
                break;
            result.add(recom.get(i).name);
        }



        return result;
    }

    Comparator<Recommendation> comparator = new Comparator<Recommendation>() {
        @Override
        public int compare(Recommendation o1, Recommendation o2) {
            return o2.score-o1.score;
        }
    };

    public User(String user) {
        name= user;
    }

    public void friend(String friendName){
        friends.add(friendName);
        Set<String> temp = new TreeSet<>(friends);
        friends = new ArrayList<>(temp);
    }

    public void setRecomVisit(List<String> visitors){

        for(int i=0; i<visitors.size(); i++){
            boolean check = recommendationList.containsKey(visitors.get(i));
            Recommendation recommendation = new Recommendation();
            if(check){
                recommendation = recommendationList.get(visitors.get(i));
            }
            recommendation.name=visitors.get(i);
            recommendation.visit++;
            recommendationList.put(visitors.get(i) , recommendation);
        }

        //        for(int i=0; i< visitors.size(); i++){
//            System.out.println("어디가 문제니?");
//            boolean check = recommendationList.containsKey(visitors.get(i));
//            Recommendation temp = new Recommendation();
//            if(check){
//            System.out.println("어디가 문제니??");
//                temp = recommendationList.get(visitors.get(i));
//            }
//            temp.visit++;
//            recommendationList.put(temp.name, temp);
//            System.out.println("어디가 문제니?????");
//        }
    }

    public void setRecomFriends() {
        recommendationList = new HashMap<>();
        for (String myFriendName : friends) {
            User myFriend = UserDB.userList.get(myFriendName);
            for (String friendOfFriends : myFriend.friends) {
                if (!friendOfFriends.equals(name)) {
                    boolean check = recommendationList.containsKey(friendOfFriends);


                    Recommendation recommendation = new Recommendation();
                    recommendation.friendsKnow = new HashMap<>();
                    recommendation.name = friendOfFriends;

                    if (check)
                        recommendation = recommendationList.get(friendOfFriends);

                    recommendation.friendsKnow.put(friendOfFriends, myFriendName);
                    recommendationList.put(friendOfFriends, recommendation);
                }
            }
        }
    }
}
