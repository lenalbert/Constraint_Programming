import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;

public class MagicSquareChoco {

    public static void main(String[] args) {
        
        Model model = new Model("MagicSquare");

        int n=3;
        IntVar[][] V = model.intVarMatrix("V", n, n, 1, n*n);
        
    
    }
    
}
