class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int maxi=-(int)1e9;
        for(int pile:piles){
            maxi=Math.max(maxi,pile);
        }
        int low=1;
        int high=maxi;
        int minspeed=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(canEat(piles,h,mid)){
                minspeed=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return minspeed;
    }
    public boolean canEat(int piles[],int h,int k){
        long hours=0;
        for(int pile:piles){
            hours+=(pile+k-1)/k;
            if(hours>h)return false;

        }
        if(hours<=h)return true;
        return false;
    }
}