package weather.mufengjun260.com.androidweather;

import android.util.Xml;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 实现网络数据访问
 * XML文件解析
 * Created by msi on 2016/6/17.
 */
public class WeatherUtil {
    private static String URL = "http://www.webxml.com.cn/WebServices/WeatherWebService.asmx/getWeatherbyCityName";

    /**
     * 实现返回访问网络上的天气数据
     *
     * @param city
     * @return
     * @throws RuntimeException
     */
    public static String getWeather(String city) throws RuntimeException {
        String xml = null;

        try {
            HttpPost request = new HttpPost(URL);
            //封装请求参数
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("theCityName", city));

            HttpEntity entity = new UrlEncodedFormEntity(params);
            request.setEntity(entity);
            //发送请求
            HttpClient client = new DefaultHttpClient();
            HttpResponse response = client.execute(request);
            //判断Http请求返回
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                //response.getEntyty()返回xml文件
                xml = EntityUtils.toString(response.getEntity());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return xml;
    }

    /**
     * 解析网络上返回的XML
     *
     * @param xml
     * @return
     * @throws RuntimeException
     * @throws XmlPullParserException
     */
    public static List<String> parseXML(String xml) throws RuntimeException, XmlPullParserException {
        List<String> weatherDatas = new ArrayList<String>();

        XmlPullParser pull = Xml.newPullParser();
        StringReader in = new StringReader(xml);

        try {
            pull.setInput(in);
            int eventType = pull.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_TAG: {
                        String tag = pull.getName();
                        if ("string".equalsIgnoreCase(tag)) {
                            weatherDatas.add(pull.nextText());
                        }
                        break;
                    }
                    default: {
                        break;
                    }
                }
                eventType = pull.next();  //获取下一循环
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return weatherDatas;
    }

}
