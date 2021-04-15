import java.util.List;

public class NQueens {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        int n=15;
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
        long end = System.currentTimeMillis();
        System.out.println("Counting to 10000000 takes " + (end - start) + "ms");
    }


}