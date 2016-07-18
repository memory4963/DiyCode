
import java.util.Scanner;

public class Diamond {

    public static void main(String[] args) {
        int line, emp, ch, num, n, i;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        emp = (n - 1) / 2;
        int t = emp;
        ch = -1;
        num = 1;
        int tmemory = emp;
        for (emp = t; emp >= 0; emp=emp-1)
        {
            for (i = 0; i <= emp-1; i++){
                System.out.print(" ");
            };
            for (i = 1; i <= num; i++){
                if (ch==-1)
                System.out.print('o');
                else System.out.print('x');
                ch = -1*ch;
            };
            System.out.println();
            num = num + 2;
            ch = -1;
        }
        num=n-2;
        for (emp = 1; emp <= tmemory; emp++)
        {
            for (i = 1; i <= emp; i++){
                System.out.print(" ");
            };
            for (i = 1; i <= num; i++) {
                if (ch==-1)
                System.out.print('o');
                else System.out.print('x');
                ch = -1*ch;
            };
            System.out.println();
            num = num - 2;
            ch = -1;
        }
    }
}
