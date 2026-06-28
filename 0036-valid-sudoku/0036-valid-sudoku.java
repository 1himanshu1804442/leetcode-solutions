class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        HashSet<Integer> set=new HashSet<>();
         HashSet<Integer> set2=new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                char a=board[i][j];
                char b=board[j][i];
                if(a!='.'){
                if(!set.add(a-'0')){
                    return false;

                }}
                
                  if(b!='.'){
                if( !set2.add(b-'0')){
                    return false;

                }}
               
                
              

            }
            set=new HashSet<>();
            set2=new HashSet<>();
        }
        for (int boxRow = 0; boxRow < 9; boxRow += 3) {
    for (int boxCol = 0; boxCol < 9; boxCol += 3) {

        HashSet<Character> box = new HashSet<>();

        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {

                if (board[i][j] == '.') continue;

                if (!box.add(board[i][j])) {
                    return false;
                }
            }
        }
    }
}
        return true;
        
    }
}