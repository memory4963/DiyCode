/**
 * Created by mufen on 2016/1/17.
 */

import com.task.Bug;


public class Main {

    public static void main(String... args) throws Exception {


        Bug bug = null;
        boolean tmp = false;
        while (!tmp) {
            tmp = true;
            try {
                bug = new Bug();
            } catch (Exception ex) {
                tmp = false;
            }
        }
        tmp = true;
        while (tmp) {
            try {
                bug.start();
            } catch (Exception ex) {
                tmp = false;
                System.out.println(ex);
            }
        }
      
        tmp = true;
        while (tmp) {
            try {
                bug.see();
            } catch (Exception ex) {
                tmp = false;
                System.out.println(ex);
            }
        }

        tmp = true;
        while (tmp) {
            try {
                bug.hear();
            } catch (RuntimeException ex) {
                tmp = false;
                System.out.println(ex);
            }
        }

        tmp = true;
        while (tmp) {
            try {
                bug.say();
            } catch (Throwable ex) {
                tmp = false;
                System.out.println(ex);
            }
        }
        tmp = true;
        while (tmp) {
            try {
                bug.move();
            } catch (Error ex) {
                tmp = false;
                System.out.println(ex);
            }
        }
        tmp = true;
        while (tmp) {
            tmp = false;
            try {
                bug.end();
            } catch (Exception ex) {
                tmp = true;
            }

        }
    }
}
