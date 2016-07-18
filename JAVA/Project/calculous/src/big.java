/**
 * Created by mufen on 2016/3/2.
 */
import java.math.BigDecimal;

public class big {

    private static final int DEFAULT_DIV_SCALE=10;

    public static String BAdd(String a,String b){

        BigDecimal b1=new BigDecimal(a);
        BigDecimal b2=new BigDecimal(b);

        return (b1.add(b2)).toString();
    }

    public static String BSub(String a,String b){

        BigDecimal b1=new BigDecimal(a);
        BigDecimal b2=new BigDecimal(b);

        return b1.subtract(b2).toString();
    }

    public static String BMul(String a,String b){
        BigDecimal b1=new BigDecimal(a);
        BigDecimal b2=new BigDecimal(b);

        return b1.multiply(b2).toString();
    }

    public static String BDiv(String a,String b){
        BigDecimal b1=new BigDecimal(a);
        BigDecimal b2=new BigDecimal(b);

        return b1.divide(b2).toString();
    }
}
