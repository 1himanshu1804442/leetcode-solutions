class Solution {
    public boolean canArrange(int[] arr, int k) {
        int n=arr.length;
        int remc[]=new int[k];
        for(int i=0;i<n;i++){
            int rem=(arr[i]%k+k)%k;

            remc[rem]++;
        }
        if(remc[0]%2!=0)return false;
        if(k%2==0){
            if(remc[k/2]%2!=0){
                return false;
            }
        }
        for(int i=1;i<=(k-1)/2;i++){
            if(remc[i]!=remc[k-i])return false;
        }
        return true;

        
    }
}