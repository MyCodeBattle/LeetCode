class Post implements Comparable {
    public int time;
    public int id;
    public Post pre;

    public Post(int id, int time, Post pre) {
        this.time = time;
        this.id = id;
        this.pre = pre;
    }

    @Override
    public int compareTo(Object p) {
        return ((Post) p).time - time;
    }
}

class Person {
    public Set<Integer> followee;
    public List<Post> weibo;

    public Person(int userId) {
        followee = new HashSet<>();
        followee.add(userId);
        weibo = new ArrayList<>();
    }
}

public class Twitter {
    //映射 userId 和 人物实体
    public Map<Integer, Person> mp;
    public static int cnt;

    /** Initialize your data structure here. */
    public Twitter() {
        mp = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        //确定有对应的实体
        Person p = mp.putIfAbsent(userId, new Person(userId));
        if (p == null) {
            p = mp.get(userId);
        }
        p.weibo.add(new Post(tweetId, ++cnt, p.weibo.isEmpty() ? null : p.weibo.get(p.weibo.size() - 1)));
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Post> Q = new PriorityQueue<>();
        Person p = mp.get(userId);
        List<Integer> ret = new ArrayList<>();

        if (p == null) {
            return ret;
        }
        for (Integer id : p.followee) {
            if (mp.get(id) != null) {
                List<Post> weibo = mp.get(id).weibo;
                if (!weibo.isEmpty()) {
                    Q.offer(weibo.get(weibo.size() - 1));
                }
            }
        }

        while (ret.size() != 10 && !Q.isEmpty()) {
            Post curPost = Q.poll();
            ret.add(curPost.id);
            if (curPost.pre != null) {
                Q.offer(curPost.pre);
            }
        }

        return ret;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        mp.putIfAbsent(followerId, new Person(followerId));
        mp.get(followerId).followee.add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId || !mp.containsKey(followerId)) {
            return;
        }
        mp.get(followerId).followee.remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
