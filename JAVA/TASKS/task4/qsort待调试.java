
import java.util.ArrayList;
import java.util.Scanner;

class qs {

    void ch(ArrayList w, int i, int j) {
        int temp;
        temp = (int) w.get(i);
        w.set(i, w.get(j));
        w.set(j, temp);
    }

    void qs(ArrayList w, int left, int right) {
        int i, j, k, n;
        i = left;
        j = right + 1;
        k = (int) w.get(left);
        do {
            do {
                j--;
            } while ((int) w.get(j) < k);
            do {
                i++;
            } while ((int) w.get(i) < k);
            this.ch(w, i, j);
        } while (i < j);
        n = j;
        qs(w, i, n - 1);
        qs(w, n + 1, j);
    }
}

public class qsort {

    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        Scanner input = new Scanner(System.in);
        qs qs= new qs();
        while (input.hasNextFloat()) {
            al.add(input.nextFloat());
        };
        qs.qs(al,1,al.size());
        int i;
        for (i = 1; i <= al.size(); i++) {
            System.out.print(al.get(i));
        }
    }
}
