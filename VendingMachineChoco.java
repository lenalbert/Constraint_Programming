import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.*;
import java.util.*;

public class VendingMachineChoco {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        Model model = new Model("VendingMachine");

        int inserted = 200;
        int price = 180;
        
        Map<String, Integer> coinsDispo =new HashMap<String, Integer>();
        coinsDispo.put("2E", 2);
        coinsDispo.put("1E", 1);
        coinsDispo.put("50c", 1);
        coinsDispo.put("20c", 5);
        coinsDispo.put("10c", 10);
        coinsDispo.put("5c", 10);


        IntVar[] returned = new IntVar[6];
        int[] coefs = new int[6];
        int i = 0;
        returned[i] = model.intVar("twoEuros", 0, coinsDispo.get("2E").intValue());
        coefs[i] = 200;
        i++;
        returned[i] = model.intVar("oneEuros", 0, coinsDispo.get("1E").intValue());
        coefs[i] = 100;
        i++;
        returned[i] = model.intVar("fiftyCents", 0, coinsDispo.get("50c").intValue());
        coefs[i] = 50;
        i++;
        returned[i] = model.intVar("twentyCents", 0, coinsDispo.get("20c").intValue());
        coefs[i] = 20;
        i++;
        returned[i] = model.intVar("tenCents", 0, coinsDispo.get("10c").intValue());
        coefs[i] = 10;
        i++;
        returned[i] = model.intVar("fiveCents", 0, coinsDispo.get("5c").intValue());
        coefs[i] = 5;

        model.scalar(returned, coefs, "=", (inserted-price)).post();
        IntVar x = model.intVar("X", coefs[0]+coefs[1]+coefs[2]+coefs[3]+coefs[4]+coefs[5]);
        model.setObjective(Model.MINIMIZE, x);
       
        Solution s = null;
        Solver solver = model.getSolver();
        while(solver.solve()){
            s = solver.findSolution();
        }
        System.out.println(s);

    }

}
