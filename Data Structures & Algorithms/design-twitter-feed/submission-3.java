class Twitter {
    HashMap<Integer,HashSet<Integer>> map;
    HashMap<Integer, List<int[]>> tweetMap;
    int time;


    public Twitter() {
        map = new HashMap();
        tweetMap = new HashMap();
        time = 0;
        
        
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!tweetMap.containsKey(userId)){
            tweetMap.put(userId, new ArrayList<>());
        }
        tweetMap.get(userId).add(new int[]{tweetId, time++});
        
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)-> b[1]-a[1]);
        if(tweetMap.containsKey(userId)){
            for(int[] tweet: tweetMap.get(userId)){
                maxHeap.offer(tweet);
            }
        }
        if(map.containsKey(userId)){
            for(int followee: map.get(userId)){
                if(tweetMap.containsKey(followee)){
                    for(int[] tweet: tweetMap.get(followee)){
                        maxHeap.offer(tweet);
                    }
                }
            }
        }
        List<Integer> res = new ArrayList();
        while(!maxHeap.isEmpty() && res.size() <10){
            res.add(maxHeap.poll()[0]);
        }
        return res;
        
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        if(map.containsKey(followerId)){
            map.get(followerId).add(followeeId);
        }else{
            HashSet<Integer> set = new HashSet();
            set.add(followeeId);
            map.put(followerId, set);
            
        }
        
    }

    
    public void unfollow(int followerId, int followeeId) {
        if(map.containsKey(followerId)){
            map.get(followerId).remove(followeeId);
        }
        
    }
}
