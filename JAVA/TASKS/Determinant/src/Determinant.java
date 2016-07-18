/**
 * Created by mufen on 2016/1/21.
 */

import java.util.Scanner;


class BasedMsd {
    float Modulus=1;
    public float Modulus(){
        return Modulus;
    }
    public void LineChange(float[][] a, int LineA, int LineB, int Rank) {
        int tmp;
        for (tmp = 1; tmp <= Rank; tmp++) {
            BChange(a[LineA][tmp], a[LineB][tmp]);
            Modulus=-Modulus;
        }
    }

    public void RowClear(float[][] a, int LeftTop, int Rank) {
        float rate = 1;
        int Cycle;
        for (Cycle = LeftTop+1 ; Cycle <= Rank; Cycle++) {
            int tmp = LeftTop + 1;
            while (a[LeftTop][LeftTop] == 0) {
                LineChange(a, LeftTop, tmp, Rank);
                tmp++;
                if (tmp == Rank + 1){
                    return;
                };
            }
            if (a[LeftTop][LeftTop] * a[Cycle][LeftTop] != 0) {
                rate = a[LeftTop][LeftTop] / a[Cycle][LeftTop];
                Mutilply(a, Rank, Cycle, rate);
                Decline(a, Rank, Cycle, LeftTop);
            }
        }
    }

    public float Solve(float[][] a, int Rank) {
        int Cycle;
        float Csqs = 1;
        for (Cycle = 1; Cycle <= Rank-1; Cycle++) {
            RowClear(a, Cycle, Rank);
        }
        for (Cycle = 1; Cycle <= Rank; Cycle++) {
            Csqs = Csqs * a[Cycle][Cycle];
        }
        return Csqs;
    }

    public void Decline(float[][] a, int Rank, int LineA, int LineB) {   //Makes LineA=LineA-LineB
        //the body of Decline
        int tmp;
        for (tmp = 1; tmp <= Rank; tmp++) {
            a[LineA][tmp] = a[LineA][tmp] - a[LineB][tmp];
        }
    }

    public void Mutilply(float[][] a, int Rank, int LineA, float Num) {
        int tmp;
        for (tmp = 1; tmp <= Rank; tmp++) {
            a[LineA][tmp] = a[LineA][tmp] * Num;
        }
        Modulus=Modulus/Num;
    }

    public void BChange(float numa, float numb) {
        float tmp;
        tmp = numa;
        numa = numb;
        numb = tmp;
    }


    public void InputLine(float[][] a, int line, int Rank) {
        int tmp, num = 0;
        String snum;
        System.out.println("Please input the line " + line + " with a line of " + Rank + " numbers");
        Scanner input = new Scanner(System.in);
        for (tmp = 1; tmp <= Rank; tmp++) {
            boolean jump = false;
            while (!jump) {
                jump = true;
                snum = input.next();
                try {
                    num = Integer.parseInt(snum);
                } catch (NumberFormatException ignore) {
                    jump = false;
                    System.out.println("Please recheck the line " + line + " and retype the line");
                }
            }
            a[line][tmp] = num;
        }
        //the body of InputLine
    }

    public void OutputLine(float[][] a, int line, int Rank) {
        int tmp;
        for (tmp = 1; tmp <= Rank; tmp++) {
            System.out.print(a[line][tmp] + " ");
        }
        System.out.println();
    }

    public void OutputMatrix(float[][] a, int Rank) {
        int tmp;
        for (tmp = 1; tmp <= Rank; tmp++) {
            OutputLine(a, tmp, Rank);
        }
    }
}


public class Determinant {
    float Modulus=1;
    public static void main(String[] args) throws Exception {
        String sRank;
        int Rank = 0;
        BasedMsd BasedMsd = new BasedMsd();
        Scanner input = new Scanner(System.in);
        boolean jump = false;
        while (!jump) {
            jump = true;
            System.out.println("Please input the step of the matrix");
            sRank = input.next();
            try {
                Rank = Integer.parseInt(sRank);
            } catch (NumberFormatException ignore) {
                jump = false;
                System.out.println("Please check your type,and retype an Integer which means the step of the matrix!!");
            }
        }
        float[][] a;                       //a[Rank][Rank],the location of Rank always means the num of line,and it of weight means which of row!
        a = new float[Rank + 1][Rank + 1];
        int tmp;
        for (tmp = 1; tmp <= Rank; tmp++) {
            BasedMsd.InputLine(a, tmp, Rank);
        }
        System.out.println("The matrix that will be calculated its determinant is:");
        BasedMsd.OutputMatrix(a, Rank);
        float csqs = 1;
        csqs = BasedMsd.Solve(a, Rank)*BasedMsd.Modulus();
        System.out.println("The determinant of the matrix is " + csqs);

    }
}

