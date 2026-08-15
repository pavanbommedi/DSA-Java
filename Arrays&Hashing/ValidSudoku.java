import java.util.*;
class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        //row wise check
        for(int row=0;row<9;row++){
            Map<Character,Integer> map = new HashMap<>();
            for(int col=0;col<9;col++){
                if(board[row][col]!='.'){
                    if(map.containsKey(board[row][col])) return false;
                    else map.put(board[row][col],1);
                }
            }
        }
        //col wise check
        for(int col=0;col<9;col++){
            Map<Character,Integer> map = new HashMap<>();
            for(int row=0;row<9;row++){
                if(board[row][col]!='.'){
                    if(map.containsKey(board[row][col])) return false;
                    else map.put(board[row][col],1);
                }
            }
        }
        //3*3 check
        for(int row=0;row<9;row+=3){
            for(int col=0;col<9;col+=3){
                Map<Character,Integer> map = new HashMap<>();
                for(int startRow = row;startRow<row+3;startRow++){
                    for(int startCol=col;startCol<col+3;startCol++){
                        if(board[startRow][startCol]!='.'){
                            if(map.containsKey(board[startRow][startCol])) return false;
                            else map.put(board[startRow][startCol],1);
                        }
                    }
                }
            }
        }
        return true;


    }
}