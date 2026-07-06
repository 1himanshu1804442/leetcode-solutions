class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[0]==b[0]){
                return Integer.compare(b[1],a[1]);
            }
            return Integer.compare(a[0],b[0]);
        });
        int cnt=0;
        int maxend=0;
        for(int interval[]:intervals){
            if(maxend<interval[1]){
                cnt++;
                maxend=interval[1];
            }
            


        }
        return cnt;
        
    }
}