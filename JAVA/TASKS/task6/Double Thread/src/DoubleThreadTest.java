/**
 * Created by mufen on 2016/1/18.
 */


import java.util.Scanner;


public class DoubleThreadTest implements Runnable {

    static long tmp, count;
    static boolean finished = false;

    public static void main(String[] args) {
        input();
        long countTmp=count;
        DoubleThreadTest Th = new DoubleThreadTest();
        finished = false;
        Thread Tha = new Thread(Th, "Thread one");
        Thread Thb = new Thread(Th, "Thread two");
        Tha.start();
        while (!finished){
            try {
                Thread.sleep(100);
            }catch (InterruptedException ex){
                //do nothing
            }
        }
        count=countTmp;
        Thb.start();

    }

    static void input() {
        Scanner input = new Scanner(System.in);
        String CountInString;
        finished = false;
        while (!finished) {
            finished = true;
            CountInString = input.next();
            try {
                count = Long.parseLong(CountInString);
            } catch (NumberFormatException ex) {
                finished = false;
                System.out.println("Please input a fucking number!!!");
            }
        }
    }

    synchronized public void run() {
        for (tmp = 1; tmp <= 100000; tmp++) {
            count++;
        }
        finished = true;
        System.out.println(count);
    }
}
