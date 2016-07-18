package weather.mufengjun260.com.androidweather;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "weather.mufengjun260.com.androidweather.app";
    public EditText tvOfCity;
    private Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) throws RuntimeException {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void showWeather(View view) {
        Intent intent = new Intent(this, ShowWeatherActivity.class);
        EditText editText = (EditText) findViewById(R.id.tvOfCity);
        String cityName = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, cityName);
        startActivity(intent);
    }

}
