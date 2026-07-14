class Solution {
    HashMap<Integer,List<Integer>> preMap;
    HashSet<Integer> visited;
    HashSet<Integer> visiting;
    List<Integer> order;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        preMap= new HashMap<>();
        visited = new HashSet<>();
        visiting = new HashSet<>();
        order = new ArrayList();
        for(int i =0; i<numCourses;i++){
            preMap.put(i, new ArrayList());
        }
        for(int[] pre: prerequisites){
            preMap.get(pre[0]).add(pre[1]);
        }
        for(int i=0; i<numCourses;i++){
            if(!dfs(i)){
                return new int[0];
            }
        }
        int[] ans = new int[numCourses];
        for(int i=0; i<numCourses;i++){
            ans[i] = order.get(i);
        } 
        return ans;
    }
    private boolean dfs(int course){
        if(visiting.contains(course))return false;
        if(visited.contains(course)) return true;
        visiting.add(course);

        for(int pre:preMap.get(course)){
            if(!dfs(pre)){
                return false;
            }
        }
        visiting.remove(course);
        visited.add(course);
        order.add(course);
        return true;
    }
}
