class Solution {
    HashMap<Integer,List<Integer>> preMap;
    HashSet<Integer> visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        preMap = new HashMap<>();
        visited = new HashSet<>();

        for(int i = 0; i<numCourses;i++){
            preMap.put(i, new ArrayList<>());
        }

        for(int i = 0; i<prerequisites.length; i++){
            preMap.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        for(int i=0; i<numCourses;i++){
            if(!dfs(i)) return false;
        }
        return true;
    }

    public boolean dfs(int crs){
        if(visited.contains(crs)) return false;

        if(preMap.get(crs).isEmpty()) return true;

        visited.add(crs);
        List<Integer> crsList = preMap.get(crs);
        for(int pre: crsList){
            if(!dfs(pre)) return false;
        }
        visited.remove(crs);
        preMap.put(crs,new ArrayList());
        return true;
    }
}
