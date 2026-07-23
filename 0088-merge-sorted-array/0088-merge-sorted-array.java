class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left=0;
        int right=0;
        int arr[]=new int[nums1.length];
        int index=0;
        while(left<m&&right<n){
            if(nums1[left]==nums2[right]){
                arr[index++]=nums1[left];
                arr[index++]=nums2[right];
                left++;
                right++;
            }
            else if(nums1[left]<nums2[right]){
                arr[index++]=nums1[left];
                left++;

            }
            else{
                arr[index++]=nums2[right];
                right++;
            }
        }
        while(left<m){
            arr[index++]=nums1[left];
            left++;
        }
        while(right<n){
            arr[index++]=nums2[right];
            right++;
        }
        index=0;
        for(int num:arr){
            nums1[index++]=num;
        }
        
    }
}