import java.util.List;
import java.util.HashSet;
import java.util.*;

public class TwoPlusTwo {

    public static void main(String[] args) {
        Comb c = new Comb(6, 10);

        outerloop:
        for (List<Integer> p: c) {
            Set<Integer> set = new HashSet<>();
            for (int i=0; i<p.size(); i++){
                if (!set.add(p.get(i))){
                    continue outerloop;
                }
            }
            if (p.get(0)==0 || p.get(3)==0){
                continue;
            }
            if(2*(100*p.get(0) + 10*p.get(1) + p.get(2)) != 1000*p.get(3) + 100*p.get(2) + 10*p.get(4) + p.get(5)){
                continue;
            }
            for (int i=0; i<p.size(); i++){
                System.out.print(p.get(i)+",");
            }
            System.out.println("");
        }
	}

}
