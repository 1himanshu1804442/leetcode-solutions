class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        int dir[][]={{-1,0},{0,-1},{0,1},{1,0}};
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));
        int effortTo[][]=new int[m][n];
        for(int row[]:effortTo){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        effortTo[0][0]=0;
        pq.offer(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int curr[]=pq.poll();
            int r=curr[0];
            int c=curr[1];
            int d=curr[2];
            if(r==m-1&&c==n-1)return d;
            if(d>effortTo[r][c])continue;
            for(int di[]:dir){
                int nr=r+di[0];
                int nc=c+di[1];
                if(nr>=0&&nc>=0&&nr<m&&nc<n){
                    int stepeffort=Math.abs(heights[nr][nc]-heights[r][c]);
                    int maxeffort=Math.max(d,stepeffort);
                    if(maxeffort<effortTo[nr][nc]){
                        effortTo[nr][nc]=maxeffort;
                        pq.add(new int[]{nr,nc,maxeffort});
                    }
                }
            }

        }
        return 0;
    }
}