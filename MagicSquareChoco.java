import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;

public class MagicSquareChoco {

    public static void main(String[] args) {
        
        long start = System.currentTimeMillis();
        int n=3;
        int sum = (n*(n*n+1))/2;

        Model model = new Model("MagicSquare");
        IntVar[][] vMat = model.intVarMatrix("V", n, n, 1, n*n);
        IntVar[] vAll = new IntVar[n*n];
        IntVar[] vDiag1 = new IntVar[n];
        IntVar[] vDiag2 = new IntVar[n];
        IntVar[] vRow = new IntVar[n];
        IntVar[] vCol = new IntVar[n];

        for(int i=0; i<n; i++){

            vDiag1[i] = vMat[i][i];
            vDiag2[i] = vMat[n-i-1][i];
            
            for(int j=0; j<n; j++){
                vRow[j] = vMat[i][j];
                vCol[j] = vMat[j][i];
                vAll[i*n+j] = vMat[i][j];
            }
            model.sum(vRow, "=", sum).post();
            model.sum(vCol, "=", sum).post();

        }
        model.allDifferent(vAll).post();

        

        model.sum(vDiag1, "=", sum).post();
        model.sum(vDiag2, "=", sum).post();

        Solver solver = model.getSolver();
        for(var s:solver.findAllSolutions()){
            System.out.println(s);
        }
    
        long end = System.currentTimeMillis();
        System.out.println("Magic Square w/ choco takes " + (end - start) + "ms");
    }
    
}
