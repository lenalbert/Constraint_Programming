import java.util.Arrays;

public class NQueensConstraint
{
	public static void main(String[] args) {
        showNQueenSolution(8);
	}

    public static boolean solveNQueens(boolean[][] board, int column){
        if(column >= board.length){
            return true;
        }
        for (int i=0; i<board.length; i++){
            if(isValid(board, i, column)){
                board[i][column]=true;
                if(solveNQueens(board, column+1)){
                    return true;
                }
                board[i][column]=false;
            }
        }
        return false;
    }


    public static boolean isValid(boolean[][] board, int row, int column){
        for(int i=0; i<column; i++){
            if(board[row][i]){
                return false;
            }
        }
        for(int i=row, j=column; i>=0 && j>=0; i--, j--){
            if(board[i][j]){
                return false;
            }
        }
        for(int i=row, j=column; i>=0 && j>=board.length; i--, j++){
            if(board[i][j]){
                return false;
            }
        }
        return true;
    }

    public static void showNQueenSolution(int n){
        boolean[][] board = new boolean[n][n];
        if(solveNQueens(board, 0) == false){
            System.out.println("No solution found");
        }
        else {
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    System.out.print(board[i][j]+" ");
                }
                System.out.println(" ");
            }
        }        
    }

}

