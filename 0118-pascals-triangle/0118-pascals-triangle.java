class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>  triangle=new ArrayList<>();
        if(numRows==0)return triangle;
        for(int i=0;i<numRows;i++){
            List<Integer> row=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0||j==i){
                    row.add(1);
                }
                else{
                    List<Integer> prevrow=triangle.get(i-1);
                    row.add(prevrow.get(j-1)+prevrow.get(j));
                }

            }
            triangle.add(row);
        }
        return triangle;
        
    }
}