/**
 * Created by mufen on 2016/3/2.
 */

import java.util.Scanner;


public class Calculate {
    public static void main(String[] args) {
        String tmp;
        Based bsd = new Based();
        Scanner input=new Scanner(System.in);
        tmp=input.next();
        int end;
        end=tmp.length()-1;
        tmp=bsd.cal(0,end,tmp);

        System.out.println(tmp);

    }
}
