import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.HashSet;
import java.util.*;

public class NQueens {

    public static void main(String[] args) {
        showNQueenSolution(8);

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


    public static boolean solveNQueens(boolean[][] board, Comb comb, int row){

        if(row >= board.length){
            return true;
        }

        outerloop:
        for (List<Integer> p: comb) {
            int qi = -1;
            for (int j=0; j<p.size(); j++){
                if (p.get(j)==1 ){
                    if(qi != -1) {
                        continue outerloop;
                    }
                    qi=j;
                }
            }
            if (qi == -1){
                continue;
            }
            System.out.println("queen column = "+qi);
            if (isValid(board, row, qi)){
                board[row][qi] = true;
                if(solveNQueens(board, comb, row+1)){
                    return true;
                }
                board[row][qi]=false;
            }
        }
        return false;
    }


    public static void showNQueenSolution(int n){
        boolean[][] board = new boolean[n][n];
        // TODO USE Comb(n, n) => find a candidate solution and test it
        Comb comb = new Comb(n, 2);
        if(solveNQueens(board, comb, 0) == false){
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