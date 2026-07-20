class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        int temp[]=new int[m*n];
        int index=0;
        int totalindex=m*n;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                temp[(index+k)%totalindex]=grid[i][j];
                index++;
            }
        }
        int l=0;
        List<List<Integer>> res=new ArrayList<>();
  
        for(int i=0;i<n;i++){
                  List<Integer> list=new ArrayList<>();
            for(int j=0;j<m;j++){
                list.add(temp[l++]);
            }
            res.add(list);

        }
        return res;
        

        

    }
}