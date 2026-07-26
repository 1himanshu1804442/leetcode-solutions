class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        long totalf=(long)m*k;
        if(totalf>n)return -1;
        int low=0;
        int high=0;
        int mini=-(int)1e9;
        for(int day:bloomDay){
            low=Math.min(low,day);
            high=Math.max(high,day);
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(canBloom(bloomDay,mid,m,k)){
                mini=mid;
                high=mid-1;

            }else{
                low=mid+1;
            }


        }
        return mini;


        
    }

    public boolean canBloom(int bloom[],int mid,int m,int k){
        int adjflowers=0;
        int bouquets=0;
        for(int i=0;i<bloom.length;i++){
            if(bloom[i]<=mid){
                adjflowers++;
                if(adjflowers==k){
                    bouquets++;
                    adjflowers=0;
                }
            }else{
                adjflowers=0;
            }
        }
        return bouquets>=m;
    }
}