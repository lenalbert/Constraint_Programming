import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.solver.variables.Task;

public class CumulativeChoco {

    public static void main(String[] args) {

        Model model = new Model("Example");

        Task[] tasks = new Task[4];
        int d = 1;
        for (int i = 0; i < 4; i++) {
            IntVar start = model.intVar("S"+i, 1, 9);
            IntVar duration = model.intVar("D"+i, d++);
            IntVar end = model.intVar("E"+i, 1, 8);
            tasks[i] = new Task(start, duration, end);
        }
        IntVar[] heights = new IntVar[4];
        int[] val = new int[]{1, 2, 5, 7};
        for (int i = 0; i < val.length; i++) {
            heights[i] = model.intVar("H"+i, val[i]);
        }
        IntVar limit = model.intVar("L", 7);

        model.cumulative(tasks, heights, limit).post();

        Solver solver = model.getSolver();
        for(var s:solver.findAllSolutions()){
            System.out.println(s);
        }
    }
    
}
