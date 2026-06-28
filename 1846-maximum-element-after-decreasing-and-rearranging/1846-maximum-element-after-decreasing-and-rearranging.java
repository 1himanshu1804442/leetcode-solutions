class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n=arr.length;
        int maxi=0;
        Arrays.sort(arr);
        if(arr[0]!=1){
            arr[0]=1;
        }
        if(n==1){
            return 1;
        }
        for(int i=1;i<n;i++){
            if(arr[i]-arr[i-1]<=1){
                maxi=Math.max(arr[i],maxi);
            }
            else{
                arr[i]=arr[i-1]+1;
                maxi=Math.max(arr[i],maxi);
            }

        }
        return maxi;

        
    }
}