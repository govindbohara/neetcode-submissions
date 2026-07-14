class Solution {
    HashMap<Integer,List<Integer>> preMap;
    HashSet<Integer> visited;
    public boolean validTree(int n, int[][] edges) {
        if(n==0) return true;
        preMap = new HashMap<>();
        visited = new HashSet<>();
        for(int i=0; i<n;i++){
            preMap.put(i, new ArrayList());
        }
        for(int i=0; i<edges.length;i++){
            preMap.get(edges[i][0]).add(edges[i][1]);
            preMap.get(edges[i][1]).add(edges[i][0]);
        }
        return dfs(0,-1) && n== visited.size();

    }
    public boolean dfs(int n, int prev){
        if(visited.contains(n)) return false;
        visited.add(n);
        for(int neighbour: preMap.get(n)){
            if(neighbour == prev){
                continue;
            }
            if(!dfs(neighbour,n)){
                return false;
            }
        }
        return true;
    }
}
