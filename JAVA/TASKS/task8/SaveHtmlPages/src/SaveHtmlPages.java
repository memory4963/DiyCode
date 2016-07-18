/**
 * Created by mufen on 2016/2/2.
 */

import java.net.*;
import java.io.*;

class based {
    public byte[] TurnStringToByte(String Tmp) {
        if (Tmp.length() > 0) {
            byte[] btmp = new byte[Tmp.length()];
            int tmpint;
            for (tmpint = 0; tmpint <= Tmp.length() - 1; tmpint++) {
                btmp[tmpint] = (byte) Tmp.charAt(tmpint);
            }
            return btmp;
        } else return null;
    }
}

public class SaveHtmlPages {
    public static void main(String[] arguments) {
        final String TheUrl = "http://www.uestc.edu.cn";
        URL page = null;
        based bsd = new based();


        try {
            page = new URL(TheUrl);
        } catch (MalformedURLException ex) {
            //do nothing;
        }


        File file;
        FileWriter fw = null;
        BufferedWriter bw = null;


        try {
            file = new File("SaveHtmlPages.html");
            fw = new FileWriter(file, false);
            bw = new BufferedWriter(fw);
            if (!file.exists()) {
                System.out.println("Can't found the file,the program is going to create it!");
                if (!file.createNewFile()) {
                    System.out.println("Failed to create the new file SaveHtmlPages!!!");
                }
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }

        try {
            HttpURLConnection connection = (HttpURLConnection) page.openConnection();
            connection.connect();
            InputStreamReader isr = new InputStreamReader((InputStream) connection.getContent());
            BufferedReader buff = new BufferedReader(isr);
            String line;

            do {
                line = buff.readLine();
                if (line!=null) {
                    bw.write(line, 0, line.length());
                    bw.newLine();
                } else bw.newLine();
            } while (line != null);
            bw.close();
        } catch (IOException ex) {
            System.out.println("IO Error: " + ex);
        }
        System.out.println("Finished to write it!");
    }
}
