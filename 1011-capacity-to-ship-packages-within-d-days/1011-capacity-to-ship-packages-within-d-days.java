class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int w=weights.length;
        int low=0;
        int high=0;
        for(int weight:weights){
            low=Math.max(low,weight);
            high+=weight;

        }
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(canShip(mid,days, weights)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
        
        
    }
    public boolean canShip(int capacity,int days,int w[]){
        int daysneeded=1;
        int currweight=0;
        for(int wt:w){
            if(wt+currweight>capacity){
                daysneeded++;
                currweight=wt;

            
            if(daysneeded>days){
                return false;
            }
            }
        else{
            currweight+=wt;
        }
        }
        return true;
    }
}