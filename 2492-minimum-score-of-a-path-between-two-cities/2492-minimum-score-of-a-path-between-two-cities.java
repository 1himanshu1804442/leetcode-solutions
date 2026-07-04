class Solution {
    public int minScore(int n, int[][] roads) {
        Queue<Integer> q=new LinkedList<>();
        List<List<int[]>> adj=new ArrayList<>();
        int m=roads.length;
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());

        }
        for(int road[]:roads){
            int u=road[0];
            int v=road[1];
            int dist=road[2];
            adj.get(u).add(new int[]{v,dist});
            adj.get(v).add(new int[]{u,dist});
        }
        boolean vis[]=new boolean[n+1];
        int miniscore=Integer.MAX_VALUE;
        q.offer(1);
        vis[1]=true;
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int neighbours[]:adj.get(curr)){
                int side=neighbours[0];
                int d=neighbours[1];
                miniscore=Math.min(d,miniscore);
                if(!vis[side]){
                    q.offer(side);
                    vis[side]=true;
                }
            }
        }
        return miniscore;

    }
}