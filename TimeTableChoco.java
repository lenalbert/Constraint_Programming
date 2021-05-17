import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.*;


public class TimeTableChoco {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        Model model = new Model("TimeTable");
        IntVar[][] timeTable = model.intVarMatrix("timeTable", 5, 10, 0, 1);


        //BoolVar b = model.boolVar();
        //c.reifyWith(b);

        IntVar total = model.intVar("total", 0);
        for(int i=0; i<5; i++){
            IntVar m = model.intVar("morning", 0);
            IntVar a = model.intVar("afternoon", 0);
            for(int j=0; j<5; j++){
                m = m.add(timeTable[i][j]).intVar();
                total = total.add(timeTable[i][j]).intVar();
            }
            for(int j=5; j<10; j++){
                a = a.add(timeTable[i][j]).intVar();
                total = total.add(timeTable[i][j]).intVar();
            }

            BoolVar b1 = model.boolVar();
            model.reifyXgtC(m, 2, b1);
            model.ifThen(b1, model.arithm(a, "<=", 2));

            BoolVar b2 = model.boolVar();
            model.reifyXgtC(a, 2, b2);
            model.ifThen(b2, model.arithm(m, "<=", 2));

        }

        model.arithm(total, "=", 30).post();

        Solver solver = model.getSolver();
        System.out.println(solver.findSolution());

    }


}
