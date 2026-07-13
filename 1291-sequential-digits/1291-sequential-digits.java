class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
     
       List<Integer> res=new ArrayList<>();
       String digits="123456789";
       for(int len=2;len<=9;len++){
        for(int i=0;i<=9-len;i++){
            String s=digits.substring(i,i+len);
            int ans=Integer.parseInt(s);
            if(ans>=low&&ans<=high)res.add(ans);
        }
       }
       return res;
        
    }
}