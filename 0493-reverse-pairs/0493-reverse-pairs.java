class Solution {
    public int reversePairs(int[] nums) {
        int n=nums.length;
        int temp[]=new int[n];
        return mergesort(nums,temp,0,n-1);
        
    }
    public int countPairs(int nums[],int low ,int mid,int high){
        int right=mid+1;
        int cnt=0;
        for(int i=low;i<=mid;i++){
            while(right<=high&&(long)nums[i]>2L*nums[right]){
                right++;
            }
            cnt+=(right-(mid+1));
        }
        return cnt;

    }
    public int mergesort(int nums[],int temp[],int low,int high){
        if(low>=high)return 0;
        int cnt=0;
        int mid=low+(high-low)/2;
       cnt+= mergesort(nums,temp,low,mid);
        cnt+=mergesort(nums,temp,mid+1,high);
        cnt+=countPairs(nums,low,mid,high);
        merge(nums,temp,low,mid,high);
       return cnt;
    }
    public void merge(int nums[],int temp[],int low,int mid,int high){
        int left=low;
        int right=mid+1;
        int k=low;
        while(left<=mid&&right<=high){
            if(nums[left]<=nums[right]){
                temp[k++]=nums[left++];
            }else{
                temp[k++]=nums[right++];
            }

        }
        while(left<=mid){
            temp[k++]=nums[left++];
        }
        while(right<=high){
            temp[k++]=nums[right++];
        }
        for(int i=low;i<=high;i++){
            nums[i]=temp[i];
        }
    }
}