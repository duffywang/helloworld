package leetcode;

import java.util.*;

/**
 * @auther : wangyufei
 * @date : 2020-09-23
 **/
public class Twitter355 {
    private static int timestamp;

    private static class Tweet {
        public int tweetid;
        public int time;
        public Tweet next;

        public Tweet(int tweetid, int time) {
            this.tweetid = tweetid;
            this.time = time;
            this.next = null;
        }
    }

    private static class User {
        private int userid;
        public Set<Integer> following;
        public Tweet head;

        public User(int userid) {
            this.userid = userid;
            this.head = null;
            follow(userid);
        }

        public void follow(int userid) {
            following.add(userid);
        }

        public void unfollow(int userid) {
            if (userid != this.userid) {
                following.remove(userid);
            }
        }

        public void post(int tweetid) {
            Tweet tweet = new Tweet(tweetid, timestamp);
            timestamp++;
            tweet.next = head;
            head = tweet;
        }
    }

    private HashMap<Integer, User> map = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public Twitter355() {

    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (!map.containsKey(userId)) {
            map.put(userId, new User(userId));
        }
        map.get(userId).post(tweetId);

    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        if (!map.containsKey(userId)) {
            map.put(userId, new User(userId));
        }
        Set<Integer> following = map.get(userId).following;

        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Tweet> priorityQueue = new PriorityQueue<Tweet>((o1, o2) -> o2.time - o1.time);
        for (Integer userid : following) {
            Tweet tweet = map.get(userid).head;
            if (tweet == null) continue;
            priorityQueue.add(tweet);
        }
        while (!priorityQueue.isEmpty()) {
            if (res.size() == 10) break;
            Tweet head = priorityQueue.poll();
            res.add(head.tweetid);
            if (head.next != null) {
                priorityQueue.add(head.next);
            }
        }
        return res;


    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (!map.containsKey(followerId)) {
            map.put(followerId, new User(followerId));
        }
        if (!map.containsKey(followeeId)) {
            map.put(followeeId, new User(followeeId));
        }
        map.get(followerId).follow(followeeId);

    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (!map.containsKey(followerId)) {
            map.put(followerId, new User(followerId));
        }
        if (!map.containsKey(followeeId)) {
            map.put(followeeId, new User(followeeId));
        }
        map.get(followerId).unfollow(followeeId);
    }


}

