class Solution {
    public List<List<Integer>> filterOccupiedIntervals(int[][] occupiedIntervals, int freeStart, int freeEnd) {
        int n=occupiedIntervals.length;
        int m=occupiedIntervals[0].length;
        Arrays.sort(occupiedIntervals,(a,b)->{
            if(a[0]!=b[0])return Integer.compare(a[0],b[0]);
        else return Integer.compare(a[1],b[1]);
        });
        List<int[]> ans=new ArrayList<>();
    int curr[]=occupiedIntervals[0];
        for(int i=1;i<n;i++){
            int next[]=occupiedIntervals[i];
            if(next[0]<=curr[1]+1){
                curr[1]=Math.max(curr[1],next[1]);
             
                
            }else{
                ans.add(curr);
                curr=next;
            }
        }
                ans.add(curr);
               List<List<Integer>> res=new ArrayList<>();       
for(int interval[]:ans){
    int start=interval[0];
    int end=interval[1];
    if(start<freeStart){
        res.add(Arrays.asList(start,Math.min(end,freeStart-1)));
    }
    if(end>freeEnd){
        res.add(Arrays.asList(Math.max(start,freeEnd+1),end));
    }
}
return res;
    }
}