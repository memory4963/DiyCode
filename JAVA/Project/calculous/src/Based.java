/**
 * Created by mufen on 2016/3/2.
 */
public class Based {
    big bg = new big();
    int AllStr,AllEnd;

    private String BitCal(String tmp, char type, int Gpnt) {
        int IntTmp = Gpnt;
        boolean jump = false;
        String FinStr= "";
        String FinTmp= "";
        while (!jump) {
            IntTmp--;
            if (IntTmp>=0){
                if ((int) tmp.charAt(IntTmp) < '0' || (int) tmp.charAt(IntTmp) > '9') {
                    jump = true;
                }
            }else jump=true;
        }

        int sta = IntTmp + 1;
        if (sta==Gpnt-1) {
            FinStr=FinStr+tmp.charAt(sta);
        }else{
            FinStr = this.cut(tmp, sta, Gpnt-1);
        }
        AllStr = sta;

        jump = false;
        IntTmp = Gpnt;
        while (!jump) {
            IntTmp++;
            if (IntTmp<=tmp.length()-1){
                if ((int) tmp.charAt(IntTmp) < '0' || (int) tmp.charAt(IntTmp) > '9') {

                    jump = true;
                }
            }else jump=true;
        }

        int end = IntTmp - 1;
        if (end==Gpnt+1) {
            FinTmp=FinTmp+tmp.charAt(sta);
        }else{
            FinTmp = this.cut(tmp, Gpnt + 1, end);
        }

        AllEnd=end;


        switch (type) {
            case '*':
                FinStr = bg.BMul(FinStr, FinTmp);
            case '/':
                FinStr = bg.BDiv(FinStr, FinTmp);
            case '+':
                FinStr = bg.BAdd(FinStr, FinTmp);
            case '-':
                FinStr = bg.BSub(FinStr, FinTmp);
        }

        return FinStr;
    }

    private String cut(String tmp, int str, int end) {
        String FinStr;
        FinStr = tmp.substring(str, end);

        return FinStr;
    }

    public  String Change(String tmp,int str,int end,String FinStr){
        String t=tmp.substring(str,end+1);

        return tmp.replaceFirst(t,FinStr);
    }

    public String cal(int sta, int end, String tmp) {
        int otmp, itmp, Gpnt;
        boolean jump = false;

        while (!jump) {
            Gpnt = tmp.indexOf('*');

            {
                if (Gpnt == -1) {
                    Gpnt = tmp.indexOf('/');

                    {
                        if (Gpnt == -1) {
                            Gpnt = tmp.indexOf('+');

                            {
                                if (Gpnt == -1) {
                                    Gpnt = tmp.indexOf('-');

                                    {
                                        if (Gpnt == -1) {
                                            jump = true;
                                        } else {
                                            String Bit=BitCal(tmp, '-', Gpnt);
                                            Change(tmp,AllStr,AllEnd,Bit);
                                        }
                                    }

                                } else {
                                    String Bit=BitCal(tmp, '+', Gpnt);
                                    System.out.println("Fuckkkkkkkkkkkkkkkkkk");
                                    tmp=Change(tmp,AllStr,AllEnd,Bit);
                                    System.out.println(tmp);
                                }
                            }
                        } else {
                            String Bit=BitCal(tmp, '/', Gpnt);
                            Change(tmp,AllStr,AllEnd,Bit);
                        }
                    }
                } else {
                    String Bit=BitCal(tmp, '*', Gpnt);
                    Change(tmp,AllStr,AllEnd,Bit);
                }
            }
        }

        return tmp;
    }
}


