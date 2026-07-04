class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
       int V=graph.length;
        List<List<Integer>> adjrev=new ArrayList<>();
        for(int i=0;i<V;i++){
            adjrev.add(new ArrayList<>());
        }
           int indegree[]=new int[V];
        for(int i=0;i<V;i++){
        for(int it:graph[i]){
            adjrev.get(it).add(i);
            indegree[i]++;
        }
    }
        Queue<Integer> q=new LinkedList<>();
     
        for(int i=0;i<V;i++){
          if(indegree[i]==0){
            q.add(i);
          }

        }
        List<Integer> safenode=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.poll();
            safenode.add(node);
            for(int it:adjrev.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        Collections.sort(safenode);
        return safenode;

        
    }
}