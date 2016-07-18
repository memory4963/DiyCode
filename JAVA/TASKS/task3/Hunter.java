import java.util.Scanner;

/**
 *
 * @author mufengjun260
 */
//HP:health point生命值 
//MP:Magic point 魔力值
//ATK:Attack point攻击力
class Killer {

    String surname = "surname";
    int HP, ATK, EXATK, FATK = 0;
    String WPN = "null";

    void cin() {
        Scanner input = new Scanner(System.in);
        System.out.print("please cin player's name:   ");
        this.surname = input.nextLine();
        System.out.print("please cin player " + this.surname + "'s Hp:   ");
        this.HP = input.nextInt();
        System.out.print("please cin player " + this.surname + "'s ATK:   ");
        this.ATK = input.nextInt();
        System.out.print("please cin player " + this.surname + "'s Weapon:   ");
        this.WPN=input.nextLine();
        this.WPN = input.nextLine();
        System.out.print("please cin player " + this.surname + "'s EXATK:   ");
        this.EXATK = input.nextInt();
        FATK = ATK + EXATK;
    }
}

class fuck {

    void fuck(Killer a, Killer b) {
        b.HP = b.HP - a.FATK;
        if (b.HP<0) b.HP=0;
        System.out.println(a.surname + " injured " + b.surname + " " + a.FATK + "Point of HP by " + a.WPN + "(+" + a.EXATK + ")"+" ,and "+b.surname+" also have "+b.HP+" point of HP");
    }

    void win(Killer a, Killer b) {
        if (a.HP > b.HP) {
            System.out.println(a.surname + " is the only winner!!!");

        } else if (a.HP < b.HP) {
            System.out.println(b.surname + " is the only winner!!!");
        } else {
            System.out.println(a.surname + " " + b.surname + " are both the winner!");
        }
    }
}

class Hunter {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Killer a = new Killer();
        Killer b = new Killer();
        fuck fuck = new fuck();
        int t = 1;
        a.cin();
        t = 2;
        b.cin();
        int swi = -1;
        while (a.HP > 0 && b.HP > 0) {
            if (swi == -1) {
                fuck.fuck(a, b);
            } else {
                fuck.fuck(b, a);
            }
        }
        fuck.win(a, b);

    }
}

