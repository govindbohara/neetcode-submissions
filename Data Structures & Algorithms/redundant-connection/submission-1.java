class Solution {
    HashMap<Integer,List<Integer>> map;
    HashSet<Integer> visited;
    public int[] findRedundantConnection(int[][] edges) {
        map = new HashMap<>();

        for(int i=1; i<=edges.length;i++){
            map.put(i,new ArrayList());
        }

        for(int[] edge: edges){
            visited = new HashSet<>();
            if(dfs(edge[0], edge[1])){
                return edge;
            }
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        return new int[0];
    }
    public boolean dfs(int node, int target){
        if(node ==target ) return true;
        if(visited.contains(node)) return false;

        visited.add(node);

        for(int neighbour: map.get(node)){
            if(dfs(neighbour, target)){
                return true;
            }
        }
        return false;
    }

}
