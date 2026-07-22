class Solution {
    
    public void rotate(int[][] matrix) {
        int n=matrix.length;

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                swap(matrix,i,j,j,i);

            }
        }
        for(int i=0;i<n;i++){
            reverse(matrix[i]);
        }
        
    }
    public void swap(int x[][],int a ,int b,int c,int d){
        int temp = x[a][b];
          x[a][b] = x[c][d];
          x[c][d] = temp;
    }
    public void reverse(int a[]){
        int left=0;
        int right=a.length-1;
        while(left<right){
            int temp=a[left];
            a[left]=a[right];
            a[right]=temp;
            left++;
            right--;
        }
    }
}