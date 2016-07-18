import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 实现网络数据访问
 * XML文件解析
 * Created by msi on 2016/6/17.
 */

class demo {
    String city;
    String jsonInString;

    void getWeatherInfo() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                getWeatherData();
            }
        }.start();
    }

    void getWeatherData() {
        String URL = "http://apicloud.mob.com/v1/weather/query?key=1471086839694&city=" + city;
        jsonInString = connServerForResult(URL);
    }

    void getJson() throws RuntimeException {
        getWeatherInfo();
    }

    private static String connServerForResult(String strURL) {
        // HttpGet对象
        HttpGet httpRequest = new HttpGet(strURL);
        String strResult = "";
        try {
            // HttpClient对象
            HttpClient httpClient = new DefaultHttpClient();
            // 获得HttpResponse对象

            HttpResponse httpResponse = httpClient.execute(httpRequest);
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                // 取得返回的数据
                strResult = EntityUtils.toString(httpResponse.getEntity());
                System.out.println(strResult);
                //  str=new  String(str.getBytes("8859_1"),"GB2312");
                //tvJson.setText();


            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            strResult = new String(strResult.getBytes("8859_1"), "GB2312");
        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();
        }
        System.out.println(strResult);
        return strResult;
    }


    public void main(){
        getJson();
    }

    /**
     * 解析网络上返回的XML
     *
     * @param xml
     * @return
     * @throws RuntimeException
     * @throws XmlPullParserException
     */


}