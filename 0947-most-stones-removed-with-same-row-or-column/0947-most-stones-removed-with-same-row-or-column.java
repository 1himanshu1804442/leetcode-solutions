class Solution {
    class DisjointSet {
        int par[];
        int size[];
        
        public DisjointSet(int n) {
            size = new int[n + 1];
            par = new int[n + 1];
            for (int i = 0; i <= n; i++) {
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
            }
            else if (size[ux] < size[uy]) {
                par[ux] = uy;
                size[uy] += size[ux];
            }
            else { 
                par[uy] = ux;
                size[ux] += size[uy];
            }
        }
    }
    public int removeStones(int[][] stones) {
        DisjointSet ds=new DisjointSet(20001);
        HashSet<Integer> set=new HashSet<>();
        for(int stone[]:stones){
            int noderow=stone[0];
            int nodecol=stone[1]+10001;
            ds.unionsize(noderow,nodecol);
            set.add(noderow);
            set.add(nodecol);
        }
        int cnt=0;
        for(int node:set){
            if(ds.findpar(node)==node){
                cnt++;
            }

        }
        return stones.length-cnt;
    }
}