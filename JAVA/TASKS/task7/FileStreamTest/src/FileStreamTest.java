import java.io.*;
import java.util.Scanner;
import java.lang.*;

public class FileStreamTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String Tmp = input.next();

        char[] ctmp = new char[3];
        int tmpint, length = Tmp.length();
        for (tmpint = 0; tmpint <= length - 3; tmpint++) {
            ctmp[0] = Tmp.charAt(tmpint);
            ctmp[1] = Tmp.charAt(tmpint + 1);
            ctmp[2] = Tmp.charAt(tmpint + 2);
            if (ctmp[0] == 'e' && ctmp[1] == 'n' && ctmp[2] == 'd') {
                break;
            }
        }

        int len = tmpint;

        File file = new File("FileStreamTest.out");
        Writer writer = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("FileStreamTest.out",false);//如果用true则为在末尾追加，否则为覆盖
        } catch (IOException ex) {
            System.out.println(ex);
        }

        byte[] StringInByte;
        StringInByte = new byte[Tmp.length()];

        for (tmpint=0;tmpint<=Tmp.length()-1;tmpint++){
            StringInByte[tmpint]=(byte)Tmp.charAt(tmpint);
        }
            try {
                fos.write(StringInByte,0,len);
            } catch (IOException ex) {
                System.out.println(ex);
            }

    }
}

