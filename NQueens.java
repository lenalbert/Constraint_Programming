import java.util.List;
import java.util.HashSet;
import java.util.*;

public class NQueens {

    public static void main(String[] args) {

        int n=4;
        Comb comb = new Comb(n, n);

        outerloop:
        for (List<Integer> p: comb) {
            Set<Integer> set = new HashSet<>();
            for (int i=0; i<p.size(); i++){
                if (!set.add(p.get(i))){
                    continue outerloop;
                }
            }
            for (int i=0; i<p.size(); i++){
                for (int j=1; j<p.size()-i; j++){
                    if (p.get(i+j) == p.get(i)+j){
                        continue outerloop;
                    }
                    if (p.get(i+j) == p.get(i)-j){
                        continue outerloop;
                    }
                }
            }
            System.out.println(p);
        } 
    }


}