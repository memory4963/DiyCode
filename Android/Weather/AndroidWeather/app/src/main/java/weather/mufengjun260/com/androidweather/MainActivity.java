package weather.mufengjun260.com.androidweather;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static String EXTRA_MESSAGE = "weather.mufengjun260.com.androidweather.app";
    public EditText tvOfCity;
    private Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) throws RuntimeException {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //允许网络操作在主线程进行
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
    }

    public void showWeather(View view) {
        Intent intent = new Intent(this, ShowWeatherActivity.class);
        //获取传递城市名
        EditText editText = (EditText) findViewById(R.id.tvOfCity);
        String cityName = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, cityName);
        startActivity(intent);
    }

}
