class Solution {
    class DisjointSet {
        int par[];
        int size[];
        
        public DisjointSet(int n) {
            size = new int[n];
            par = new int[n];
            for (int i = 0; i < n; i++) {
                size[i] = 1;
                par[i] = i;
            }
        }
        
        public int findpar(int x) {
            if (par[x] == x) return x;
            return par[x] = findpar(par[x]);
        }
        
        public void unionsize(int x, int y) {
            int ux = findpar(x);
            int uy = findpar(y);
            
            if (ux == uy) {
                return;
            } else if (size[ux] < size[uy]) {
                par[ux] = uy;
                size[uy] += size[ux];
            } else {
                par[uy] = ux;
                size[ux] += size[uy];
            }
        }
    }
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        DisjointSet ds=new DisjointSet(n);
        int len=queries.length;
        for(int i=1;i<nums.length;i++){
            if(nums[i]-nums[i-1]<=maxDiff){
                ds.unionsize(i,i-1);
            }
        }
        boolean[] ans=new boolean[queries.length];
      int idx=0;
        for(int query[]:queries){
            int x=query[0];
            int y=query[1];
            if(ds.findpar(x)==ds.findpar(y)){
                ans[idx++]=true;
            }
            else{
                ans[idx++]=false;
            }
        }
        return ans;
        
    }
}