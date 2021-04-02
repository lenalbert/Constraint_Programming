import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.solver.variables.Task;

public class CumulativeChoco {

    public static void main(String[] args) {

        Model model = new Model("Example");

        // TODO CREATE IntVar to be able to name them
        Task[] tasks = new Task[4];
        tasks[0] =  new Task(model, 1, 9, 1, 1, 8);
        tasks[1] =  new Task(model, 1, 9, 2, 1, 8);
        tasks[2] = new Task(model, 1, 9, 3, 1, 8);
        tasks[3] = new Task(model, 1, 9, 4, 1, 8);

        IntVar[] heights = new IntVar[4];
        heights[0] = model.intVar(1);
        heights[1] =  model.intVar(2);
        heights[2] = model.intVar(5);
        heights[3] =  model.intVar(7);

        IntVar capacity = model.intVar(7);

        model.cumulative(tasks, heights, capacity).post();

        Solver solver = model.getSolver();
        System.out.println(solver.findSolution());

    }
    
}
