import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.solver.constraints.nary.automata.FA.FiniteAutomaton;


public class DecompositionChoco {

    public static void main(String[] args) {

        int n = 5;

        Model model = new Model("Decomposition");

        IntVar[] variables = model.intVarArray("V", n, 0, n);
        model.sum(variables, "=", n).post();
        model.regular(variables, new FiniteAutomaton("[1-9]+0*")).post();

        Solver solver = model.getSolver();
        for(var s:solver.findAllSolutions()){
            System.out.println(s);
        }

    
    }
    
}
