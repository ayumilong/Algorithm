/**
 * File Name: MiniTwitter.java
 * Package Name: yz.oo.design
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 10:55:02 PM Apr 19, 2016
 * Author: Yaolin Zhang
 */
package yz.oo.design;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 10:55:02 PM Apr 19, 2016
 */

class Tweet{
	static int ID = 0;
	int id;
	int user_id;
	String text;
	Tweet(int user_id, String text){
		this.id = ID++;
		this.user_id = user_id;
		this.text = text;
	}
}
class User{
    int id;
    List<Tweet> twitter;
    List<Tweet> newsFeed;
    HashSet<User> followers;
    
    User(int user_id){
        this.id = user_id;
        this.twitter = new ArrayList<>();
        this.newsFeed = new ArrayList<>();
        this.followers = new HashSet<>();
    }
    
    void addFollower(User user){
        this.followers.add(user);
    }
    
    void removeFollower(User user){
        this.followers.remove(user);
    }
    
    void addTwitter(Tweet tweet){
        this.twitter.add(0, tweet);
    }
    
    void addNewsFeed(Tweet tweet){
        this.newsFeed.add(0, tweet);
    }
    
    void pushNewsFeed(Tweet tweet){
        for(User u : followers){
            u.addNewsFeed(tweet);
        }
    }
    
    List<Tweet> getNewsFeed(){
        List<Tweet> result = new ArrayList<>();
        for(int i = 0; i < 10 && i < this.newsFeed.size(); ++i){
            result.add(this.newsFeed.get(i));
        }
        return result;
    }
    
    List<Tweet> getTimeline(){
        List<Tweet> result = new ArrayList<>();
        for(int i = 0; i < 10 && i < this.twitter.size(); ++i){
            result.add(this.twitter.get(i));
        }
        return result;
    }
    
    void updateNewsFeed(User user, boolean add){
        if(!add){
            List<Tweet> deleted = new ArrayList<>();
            for(int i = 0; i < this.newsFeed.size(); ++i){
                Tweet cur = this.newsFeed.get(i);
                if(cur.user_id == user.id){
                    deleted.add(cur);
                }
            }
            for(Tweet t : deleted){
                this.newsFeed.remove(t);
            }
        }else{
            List<Tweet> timeline = user.twitter;
            /*
            int index = 0;
            for(int i = 0; i < timeline.size(); ++i){
                Tweet cur = timeline.get(i);
                while(index < this.newsFeed.size() && this.newsFeed.get(index).id > cur.id){
                    ++index;
                }
                this.newsFeed.add(index++, cur);
            }
            */
            
        }
    }
}
class MiniTwitter1 {
    HashMap<Integer, User> users = new HashMap<>();
    
    public MiniTwitter1() {
        // initialize your data structure here.
    }
    
    private User getUser(int user_id){
        User user = this.users.get(user_id);
        if(user == null){
            user = new User(user_id);
            this.users.put(user_id, user);
        }
        return user;
    }

    // @param user_id an integer
    // @param tweet a string
    // return a tweet
    public Tweet postTweet(int user_id, String tweet_text) {
        //  Write your code here
        Tweet newTweet = new Tweet(user_id, tweet_text);
        User user = this.getUser(user_id);
        user.addTwitter(newTweet);
        user.addNewsFeed(newTweet);
        user.pushNewsFeed(newTweet);
        return newTweet;
    }

    // @param user_id an integer
    // return a list of 10 new feeds recently
    // and sort by timeline
    public List<Tweet> getNewsFeed(int user_id) {
        // Write your code here
        User user = this.getUser(user_id);
        return user.getNewsFeed();
    }
        
    // @param user_id an integer
    // return a list of 10 new posts recently
    // and sort by timeline
    public List<Tweet>  getTimeline(int user_id) {
        // Write your code here
        User user = this.getUser(user_id);
        return user.getTimeline();
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id follows to_user_id
    public void follow(int from_user_id, int to_user_id) {
        // Write your code here
        User fromUser = this.getUser(from_user_id);
        User toUser = this.getUser(to_user_id);
        toUser.addFollower(fromUser);
        fromUser.updateNewsFeed(toUser, true);
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id unfollows to_user_id
    public void unfollow(int from_user_id, int to_user_id) {
        // Write your code here
        User fromUser = this.getUser(from_user_id);
        User toUser = this.getUser(to_user_id);
        toUser.removeFollower(fromUser);
        fromUser.updateNewsFeed(toUser, false);
    }
}




//Pull method
public class MiniTwitter {
	private static int ID = 0;
    private class ListNode{
        Tweet twitter;
        ListNode next;
        ListNode(Tweet t){
            twitter = t;
        }
    }
    private HashMap<Integer, ListNode> twitters; //User to his own twitters
    private HashMap<Integer, HashSet<Integer>> friends; //User to his friends

    public MiniTwitter() {
        // initialize your data structure here.
        twitters = new HashMap<>();
        friends = new HashMap<>();
    }

    // @param user_id an integer
    // @param tweet a string
    // return a tweet
    public Tweet postTweet(int user_id, String tweet_text) {
        //  Write your code here
        Tweet cur = new Tweet(user_id, tweet_text);
        ListNode newNode = new ListNode(cur);
        if(!twitters.containsKey(user_id)){
        		twitters.put(user_id, new ListNode(null));
        }
        ListNode head = twitters.get(user_id);
        newNode.next = head.next;
        head.next = newNode;
        return cur;
    }

    // @param user_id an integer
    // return a list of 10 new feeds recently
    // and sort by timeline
    public List<Tweet> getNewsFeed(int user_id) {
        // Write your code here
        HashSet<Integer> fs = friends.get(user_id);
        PriorityQueue<ListNode> pq = new PriorityQueue<>(1, new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
                return l2.twitter.id - l1.twitter.id;
            }
            
        });
        if(fs != null){
            for(Integer id : fs){//Friends' twitter
                if(twitters.containsKey(id)){
                    pq.offer(twitters.get(id).next);
                }
            }
        }
        if(twitters.containsKey(user_id)){//Own twitter
            pq.offer(twitters.get(user_id).next);
        }
        int count = 10;
        List<Tweet> result = new ArrayList<>();
        while(count > 0 && !pq.isEmpty()){//Find first 10 twitter
            --count;
            ListNode cur = pq.poll();
            result.add(cur.twitter);
            if(cur.next != null){
                pq.add(cur.next);
            }
        }
        return result;
    }
        
    // @param user_id an integer
    // return a list of 10 new posts recently
    // and sort by timeline
    public List<Tweet>  getTimeline(int user_id) {
        // Write your code here
        List<Tweet> result = new ArrayList<>();
        if(twitters.containsKey(user_id)){
            ListNode head = twitters.get(user_id);
            int count = 10;
            while(count > 0 && head.next != null){
                result.add(head.next.twitter);
                head = head.next;
                --count;
            }
        }
        return result;
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id follows to_user_id
    public void follow(int from_user_id, int to_user_id) {
        // Write your code here
    		if(!friends.containsKey(from_user_id)){
    			friends.put(from_user_id, new HashSet<Integer>());
    		}
    		friends.get(from_user_id).add(to_user_id);
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id unfollows to_user_id
    public void unfollow(int from_user_id, int to_user_id) {
        // Write your code here
        if(friends.containsKey(from_user_id)){
            friends.get(from_user_id).remove(to_user_id);
        }
    }
}
