import java.util.Scanner;
import java.util.ArrayList; 

class qs {

    void ch(ArrayList w, int i, int j) {
        float temp;
        temp = (float) w.get(i);
        w.set(i, w.get(j));
        w.set(j, temp);
    }

    void qs(ArrayList w, int left, int right) {
        float k;
        int i, j, n;
        i = left;
        j = right + 1;
        k = (float) w.get(left);
        while (i != j) {
            while ((float) w.get(j) < k & i < j) {
                j--;
            }
            while ((float) w.get(i) > k & i < j) {
                i++;
            }
           if (i<j) 
               ch(w, i, j);
        }
        w.set(left,w.get(i));
        w.set(i,k);
        qs(w,left,i-1);
        qs(w,i+1,right);
    }
}

public class QsortWithDynamicArray {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList al = new ArrayList();
        String st;
        qs qs = new qs();
        float temp;
        while (input.hasNext()) {
            st = (String) input.next();
            if (st.equals("begin")) {
                break;
            }
            temp = Float.parseFloat(st.trim());
            al.add(temp);
        }
        System.out.println("------------------------sorting-----------------------");
        System.out.println(al.toString());
        qs.qs(al, 1, al.size());
        al.add(3.1415926);
        System.out.println("------------------------sorting-----------------------");
        System.out.println(al.toString());
    }

}
