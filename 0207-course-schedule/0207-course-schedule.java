class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int it[]:prerequisites){
            int u=it[0];
            int v=it[1];
            adj.get(u).add(v);
        }
        int indegree[]=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
           if(indegree[i]==0)q.add(i);
        }
        List<Integer> list=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.poll();
            list.add(node);
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }

        }
        if(list.size()==numCourses){
            return true;
        }
        else{
            return false;
        }
        
    }
}