class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        int n=nums.length;
       long sum=0;
        int cnt=0;
        for(int i=0;i<n;i++){
            sum=0;
            for(int j=i;j<n;j++){
                sum+=nums[j];
                if(check(sum,x)){
                    cnt++;
                }
            }
        }
        return cnt;
        
    }
    public boolean check(long sum,int x){
        if((sum%10)==x){
            long firstdigit=sum;
            while(firstdigit>=10){
                firstdigit/=10;
            }
            if(firstdigit==x){
                return true;
            }
        }
        return false;
        
    }
}