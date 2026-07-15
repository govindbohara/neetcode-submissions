class Solution {
    HashMap<Integer,List<Integer>> map;
    HashSet<Integer> visited;
    int count = 0;
    public int countComponents(int n, int[][] edges) {
        if(n==0) return 0;
        map = new HashMap<>();
        visited = new HashSet<>();

        for(int i=0; i<n;i++){
            map.put(i, new ArrayList());
        }

        for(int[] edge: edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        for(int i =0; i<n;i++){
            if(dfs(i)){
                count++;
            }
        }

        return count;

    }

    public boolean dfs(int node){
        if(visited.contains(node)) return false;

        visited.add(node);

        for(int neighbour: map.get(node)){
            dfs(neighbour);
        }
        return true;
    }
}
