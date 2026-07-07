class Solution {
    public long sumAndMultiply(int n) {
        String s=Integer.toString(n);
        StringBuilder res=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='0'){
                res.append(s.charAt(i));
                
            }
        }
        if(res.length()==0)return 0;
        long ans=Long.parseLong(res.toString());
        long ans2=ans;
        long sum=0;
        while(ans!=0){
            sum+=ans%10;
            ans=ans/10;
        }

      
            return ans2*sum;
  
        
    }
}