import java.util.List;
import java.util.HashSet;
import java.util.*;

public class NQueens {

    public static void main(String[] args) {

        int n=4;
        Perm perm = new Perm(n);

        outerloop:
        for (List<Integer> p: perm) {
            
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