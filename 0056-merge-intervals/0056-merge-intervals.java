class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int start=intervals[0][0];
        int end=intervals[0][1];
        List<int[]> ans=new ArrayList<>();
        int n=intervals.length;
        for(int i=1;i<n;i++){
            int nextstart=intervals[i][0];
            int nextend=intervals[i][1];
            if(end>=nextstart){
                end=Math.max(end,nextend);
            }else{
                ans.add(new int[]{start,end});
                start=nextstart;
                end=nextend;
            }

        }
        ans.add(new int[]{start,end});
        return ans.toArray(new int[ans.size()][]);
    }
}