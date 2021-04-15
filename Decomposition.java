import java.util.List;
import java.util.HashSet;
import java.util.*;

public class Decomposition {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        int n = 4;

        Comb comb = new Comb(n, n+1);
        Set<String> set = new HashSet<>();

        outerloop:
        for (List<Integer> c: comb) {
            int s=0;
            String str = "";
            for (int i=0; i<n; i++){
                if(c.get(i) != 0){
                    s+=c.get(i);
                    str += c.get(i);
                }
            }
            if(s!=n){
                continue outerloop;
            }
            set.add(str);
        }
        System.out.println(set);
        long end = System.currentTimeMillis();
        System.out.println("Counting to 10000000 takes " + (end - start) + "ms");
    }
}