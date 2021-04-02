import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;

public class NQueensChoco {

    public static void main(String[] args) {

        int n=4;

        Model model = new Model("NQueens");
        IntVar[] V = model.intVarArray("V", n, 1, n);

        model.allDifferent(V).post();
        for (int i=0; i<V.length; i++){
            for (int j=1; j<V.length-i; j++){
                model.arithm(V[i+j], "!=", V[i], "+", j).post();
                model.arithm(V[i+j], "!=", V[i], "-", j).post();
            }
        }

        Solver solver = model.getSolver();
        
        // TODO while loop to find all solutions
        System.out.println(solver.findSolution());
    
    }
}
