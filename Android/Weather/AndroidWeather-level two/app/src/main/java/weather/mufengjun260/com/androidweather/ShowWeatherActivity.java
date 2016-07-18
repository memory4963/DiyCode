package weather.mufengjun260.com.androidweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class ShowWeatherActivity extends AppCompatActivity {
    private List<String> list;

    private void getList(String cityName) {
        String xml = WeatherUtil.getWeather(cityName);
        if (xml != null) {
            try {
                list = WeatherUtil.parseXML(xml);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String cityName;
        cityName = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        getList(cityName);

        setContentView(R.layout.activity_show_weather);
    }
}
