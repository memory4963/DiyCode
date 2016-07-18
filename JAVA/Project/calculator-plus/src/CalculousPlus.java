/**
 * Created by mufen on 2016/2/25.
 */

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.lang.Math;

class ButtonFrame extends JFrame {
    JButton bt0 = new JButton("0");
    JButton bt1 = new JButton("1");
    JButton bt2 = new JButton("2");
    JButton bt3 = new JButton("3");
    JButton bt4 = new JButton("4");
    JButton bt5 = new JButton("5");
    JButton bt6 = new JButton("6");
    JButton bt7 = new JButton("7");
    JButton bt8 = new JButton("8");
    JButton bt9 = new JButton("9");


    public ButtonFrame() {
        super("Calculous Puls Niubility");
        Dimension dm;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pane = new JPanel();

        pane.add(bt0);
        pane.add(bt1);
        pane.add(bt2);
        pane.add(bt3);
        pane.add(bt4);
        pane.add(bt5);
        pane.add(bt6);
        pane.add(bt7);
        pane.add(bt8);
        pane.add(bt9);

        add(pane);
        setVisible(true);

        dm = this.getPreferredSize();
        setSize(dm);


    }

     static void setLookAndFeel(){
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        }catch (Exception exp){
            System.out.println(exp.getMessage());
        }
    }
}

class calcul{
    String a;

    static double calcul(String a){
        double t=0;
        int startIndex;



        return t;
    }
}


public class CalculousPlus {

    public static void main(String[] args) {
        ButtonFrame bf=new ButtonFrame();
        bf.setLookAndFeel();

    }

}
