class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st=new Stack<>();
        for(char ch:expression.toCharArray()){
            if(ch==',')continue;
            if(ch!=')'){
                st.push(ch);
            }else{
                boolean hastrue=false;
                boolean hasfalse=false;
                while(st.peek()!='('){
                    char c=st.pop();
                    if(c=='t')hastrue=true;
                    if(c=='f')hasfalse=true;

                }
                st.pop();
                char s=st.pop();
                if(s=='!'){
                    st.push(hastrue?'f':'t');
                }
                else if(s=='&'){
                    st.push(hasfalse?'f':'t');
                }
                else{
                    st.push(hastrue?'t':'f');
                }
            }
        }
        return st.peek()=='t';
        
    }
}