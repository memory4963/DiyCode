package weather.mufengjun260.com.androidweather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public TextView tvOfCity, tvOfTemperature, tvOfWeather;

    private Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) throws RuntimeException {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvOfCity = (TextView) findViewById(R.id.textViewOfCity);
        tvOfWeather = (TextView) findViewById(R.id.textView2);
        tvOfTemperature = (TextView) findViewById(R.id.textView3);
        btnUpdate = (Button) findViewById(R.id.button1);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        class WeatherThread extends Thread {

            @Override
            public void run() {
                String xml = WeatherUtil.getWeather("北京");
                if (xml != null) {
                    try {
                        List<String> list = WeatherUtil.parseXML(xml);
                        System.out.println(list);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
