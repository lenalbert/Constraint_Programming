import java.util.Arrays;

public class NQueensConstraint
{
	public static void main(String[] args) {
        long start = System.currentTimeMillis();
        showNQueenSolution(8);
        long end = System.currentTimeMillis();
        System.out.println("NQueens w/ recursive function takes " + (end - start) + "ms");
	}

    public static boolean solveNQueens(boolean[][] board, int row){
        if(row >= board.length){
            return true;
        }
        for (int i=0; i<board.length; i++){
            if(isValid(board, row, i)){
                board[row][i]=true;
                if(solveNQueens(board, row+1)){
                    return true;
                }
                board[row][i]=false;
            }
        }
        return false;
    }


    public static boolean isValid(boolean[][] board, int row, int column){
        // meme colonne
        for(int i=0; i<row; i++){
            if(board[i][column]){
                return false;
            }
        }
        // diagonal haut gauche
        for(int i=row, j=column; i>=0 && j>=0; i--, j--){
            if(board[i][j]){
                return false;
            }
        }
        // diagonal haut droite
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

