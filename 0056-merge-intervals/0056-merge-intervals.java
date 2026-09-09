class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int start=intervals[0][0];
        int end=intervals[0][1];
        int n=intervals.length;
        List<int[]> list=new ArrayList<>();
        for(int i=1;i<n;i++){
            int starti=intervals[i][0];
            int endi=intervals[i][1];
            if(end>=starti){
                end=Math.max(end,endi);
            }else{
                list.add(new int[]{start,end});
                start=starti;
                end=endi;
            }
        }
        list.add(new int[]{start,end});
        return list.toArray(new int[list.size()][]);
        
    }
}