package weather.mufengjun260.com.androidweather;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ShowWeatherActivity extends AppCompatActivity {
    private TextView tvOfAirCondition, tvOfColdIndex, tvOfDressingIndex, tvOfPollutionIndex, tvOfWashingIndex;
    private TextView tvOfCityName, tvOfTodayWeek, tvOfTodayDate;
    private TextView tvOfTodayDayTime, tvOfTodayTemperature, tvOfTodayWind;
    private TextView tvOfFuture1, tvOfFuture2, tvOfFuture3, tvOfFuture4, tvOfFuture5;

    @Override
    protected void onCreate(Bundle savedInstanceState) throws RuntimeException {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_weather);

        //获取上一个Activity输入的城市名
        Intent intent = getIntent();
        String cityName;
        cityName = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        //关联tv
        tvOfCityName = (TextView) findViewById(R.id.tvOfCityName);
        tvOfAirCondition = (TextView) findViewById(R.id.tvOfAirCondition);
        tvOfColdIndex = (TextView) findViewById(R.id.tvOfColdIndex);
        tvOfPollutionIndex = (TextView) findViewById(R.id.tvOfPollutionIndex);
        tvOfDressingIndex = (TextView) findViewById(R.id.tvOfDressingIndex);
        tvOfWashingIndex = (TextView) findViewById(R.id.tvOfWashIndex);
        tvOfTodayDayTime = (TextView) findViewById(R.id.tvOfTodayDayTime);
        tvOfTodayDate = (TextView) findViewById(R.id.tvOfTodayDate);
        tvOfTodayWeek = (TextView) findViewById(R.id.tvOfTodayWeek);
        tvOfTodayTemperature = (TextView) findViewById(R.id.tvOfTodayTemperature);
        tvOfTodayWind = (TextView) findViewById(R.id.tvOfTodayWind);
        tvOfFuture1 = (TextView) findViewById(R.id.tvOfFuture1);
        tvOfFuture2 = (TextView) findViewById(R.id.tvOfFuture2);
        tvOfFuture3 = (TextView) findViewById(R.id.tvOfFuture3);
        tvOfFuture4 = (TextView) findViewById(R.id.tvOfFuture4);
        tvOfFuture5 = (TextView) findViewById(R.id.tvOfFuture5);

        //设置字体格式
        tvOfCityName.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        tvOfTodayWind.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        tvOfTodayTemperature.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        tvOfTodayDayTime.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        tvOfFuture1.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        tvOfFuture2.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        tvOfFuture3.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        tvOfFuture4.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        tvOfFuture5.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        tvOfColdIndex.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        tvOfWashingIndex.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        tvOfDressingIndex.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        tvOfPollutionIndex.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));

        JSONObject jsonObject = null;
        try {
            jsonObject = WeatherUtil.getWeather(cityName);
            JSONArray result = jsonObject.getJSONArray("result");
            JSONArray weatherCollection = result.getJSONObject(0).getJSONArray("future");

            //tv内容设定
            tvOfCityName.setText(result.getJSONObject(0).getString("city"));
            tvOfTodayDate.setText(weatherCollection.getJSONObject(0).getString("date"));
            tvOfTodayWeek.setText(weatherCollection.getJSONObject(0).getString("week"));

            tvOfAirCondition.setText("空气质量：" + result.getJSONObject(0).getString("airCondition"));
            tvOfTodayDayTime.setText(weatherCollection.getJSONObject(0).getString("dayTime"));
            tvOfTodayTemperature.setText(weatherCollection.getJSONObject(0).getString("temperature"));
            tvOfTodayWind.setText(weatherCollection.getJSONObject(0).getString("wind"));

            tvOfWashingIndex.setText("洗车指数：" + result.getJSONObject(0).getString("washIndex"));
            tvOfColdIndex.setText("感冒指数：" + result.getJSONObject(0).getString("coldIndex"));
            tvOfDressingIndex.setText("穿衣指数：" + result.getJSONObject(0).getString("dressingIndex"));
            tvOfPollutionIndex.setText("污染指数：" + result.getJSONObject(0).getString("pollutionIndex"));

            tvOfFuture1.setText(weatherCollection.getJSONObject(1).getString("date") + " " + weatherCollection.getJSONObject(1).getString("dayTime") + "~" + weatherCollection.getJSONObject(1).getString("night") + " " + weatherCollection.getJSONObject(1).getString("temperature") + " " + weatherCollection.getJSONObject(1).getString("wind") + "\n");
            tvOfFuture2.setText(weatherCollection.getJSONObject(2).getString("date") + " " + weatherCollection.getJSONObject(2).getString("dayTime") + "~" + weatherCollection.getJSONObject(2).getString("night") + " " + weatherCollection.getJSONObject(2).getString("temperature") + " " + weatherCollection.getJSONObject(2).getString("wind") + "\n");
            tvOfFuture3.setText(weatherCollection.getJSONObject(3).getString("date") + " " + weatherCollection.getJSONObject(3).getString("dayTime") + "~" + weatherCollection.getJSONObject(3).getString("night") + " " + weatherCollection.getJSONObject(3).getString("temperature") + " " + weatherCollection.getJSONObject(3).getString("wind") + "\n");
            tvOfFuture4.setText(weatherCollection.getJSONObject(4).getString("date") + " " + weatherCollection.getJSONObject(4).getString("dayTime") + "~" + weatherCollection.getJSONObject(4).getString("night") + " " + weatherCollection.getJSONObject(4).getString("temperature") + " " + weatherCollection.getJSONObject(4).getString("wind") + "\n");
            tvOfFuture5.setText(weatherCollection.getJSONObject(5).getString("date") + " " + weatherCollection.getJSONObject(5).getString("dayTime") + "~" + weatherCollection.getJSONObject(5).getString("night") + " " + weatherCollection.getJSONObject(5).getString("temperature") + " " + weatherCollection.getJSONObject(5).getString("wind") + "\n");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
