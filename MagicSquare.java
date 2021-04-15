import java.util.List;
import java.util.HashSet;
import java.util.*;

public class MagicSquare {

    public static void main(String[] args) {

        int n=3;
        int sum = (n*(n*n+1))/2;

        Perm perm = new Perm(n*n, 1);

        outerloop:
        for (List<Integer> p: perm) {
            int[][] square = new int[n][n];
            int line = -1;
            int[] column = new int[n];
            int diag1 = 0;
            int diag2 = 0;
            int sumLine=0;

            for(int i=0; i<p.size(); i++){

                // create lines
                if(i%n == 0){
                    sumLine=0;
                    line++;
                }
                square[line][i%n] = p.get(i);
                sumLine += p.get(i);

                // test sum of lines
                if(i%n == n-1){
                    if(sumLine != sum){
                        continue outerloop;
                    }
                }

                // calcul diagonal 1
                if(line == i%n){
                    diag1 += p.get(i);
                }

                // calcul diagonal 2
                if((n-(i%n)-1) == line){
                    diag2 += p.get(i);
                }
                
            }
            // check diagonals
            if(diag1 != sum || diag2 != sum){
                continue outerloop;
            }

            // check columns
            for(int i=0; i<n; i++){
                int s=0;
                for(int j=0; j<n; j++){
                    s+= square[j][i];
                }
                if(s != sum){
                    continue outerloop;
                }
            }
            System.out.println(p);
        }

    }
    
}
