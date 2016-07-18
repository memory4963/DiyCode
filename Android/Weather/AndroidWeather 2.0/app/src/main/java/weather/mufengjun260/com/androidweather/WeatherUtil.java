package weather.mufengjun260.com.androidweather;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * 实现网络数据访问
 * XML文件解析
 * Created by msi on 2016/6/17.
 */

class WeatherUtil {
    private static String city;
    private static String jsonInString;
    private static JSONObject jsonObject = new JSONObject();
    private static boolean isEnded=false;
    private static void getWeatherInfo() {
                isEnded=false;
        new Thread() {
            @Override
            public void run() {
                super.run();
                getWeatherData();
                isEnded=true;
            }
        }.start();
    }


    private static void getWeatherData() {
        String URL = "http://apicloud.mob.com/v1/weather/query?key=1471086839694&city=" + city;
        connServerForResult(URL);
    }

    private static void getJson() throws RuntimeException {
        getWeatherInfo();
    }

    private static void  connServerForResult(String strURL) {
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
                jsonObject = new JSONObject(strResult);
                // System.out.println(strResult);
            }

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getWeather(String cityName) throws RuntimeException {
        city = cityName;
        getJson();
        while (true){
            if (isEnded) return jsonObject;
        }
    }



}