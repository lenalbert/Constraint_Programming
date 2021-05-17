import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;

public class NQueensChoco {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        int n=15;

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
        for(var s:solver.findAllSolutions()){
            System.out.println(s);
        }

        long end = System.currentTimeMillis();
        System.out.println("NQueens w/ choco takes " + (end - start) + "ms");
    
    }
}
