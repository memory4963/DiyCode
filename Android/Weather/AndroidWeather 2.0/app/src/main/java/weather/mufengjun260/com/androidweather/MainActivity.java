package weather.mufengjun260.com.androidweather;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    String cityCollection;
    public static String EXTRA_MESSAGE = "weather.mufengjun260.com.androidweather.app";
    public EditText tvOfCity;
    private Button btnUpdate;
    private JSONObject resultTmpOfCity;
    private final static String filename = "cityCollection.json";
    Spinner spinnerOfProvince, spinnerOfCity, spinnerOfArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) throws RuntimeException {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //允许网络操作在主线程进行
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        setContentView(R.layout.activity_main);
        spinnerOfProvince = (Spinner) findViewById(R.id.spinnerOfProvince);
        spinnerOfCity = (Spinner) findViewById(R.id.spinnerOfCity);
        spinnerOfArea = (Spinner) findViewById(R.id.spinnerOfArea);

        //获得String化的json数据
        cityCollection = AppJsonFileReader.getJson(getBaseContext(), filename);
        //处理json数据
        JSONArray resultOfProvince = null;
        try {
            resultTmpOfCity = new JSONObject(cityCollection);
            resultOfProvince = resultTmpOfCity.getJSONArray("result");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        final String[] arrayOfProvince = new String[34];

        //从json中获取省名
        for (int outTmp = 0; outTmp < 34; outTmp++) {
            try {
                arrayOfProvince[outTmp] = resultOfProvince.getJSONObject(outTmp).getString("province");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        final JSONArray resultOfProvinceTmp = resultOfProvince;
        //设置省spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayOfProvince);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOfProvince.setAdapter(adapter);

        //省选择后更改市spinner
        spinnerOfProvince.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                for (int outTmp = 0; outTmp < 34; outTmp++) {
                    try {
                        if (arrayOfProvince[position] == (resultOfProvinceTmp.getJSONObject(outTmp).getString("province"))) {
                            /**
                             * set jsonarray to spinner
                             */
                            final JSONArray jsonArrayOfCity = resultOfProvinceTmp.getJSONObject(outTmp).getJSONArray("city");
                            JSONObject jsonObjectOfCity = jsonArrayOfCity.getJSONObject(0);
                            System.out.println(jsonArrayOfCity.length());
                            final String[] arrayOfCity = new String[jsonArrayOfCity.length()];

                            for (int inTmp = 0; inTmp < jsonArrayOfCity.length(); inTmp++) {
                                arrayOfCity[inTmp] = jsonArrayOfCity.getJSONObject(inTmp).getString("city");
                            }
                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, arrayOfCity);
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spinnerOfCity.setAdapter(adapter);

                            //市选择后更改区县spinner
                            spinnerOfCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    for (int outTmp = 0; outTmp < arrayOfCity.length; outTmp++) {
                                        try {
                                            if (arrayOfCity[position] == (jsonArrayOfCity.getJSONObject(outTmp).getString("city"))) {
                                                /**
                                                 * set jsonarray to spinner
                                                 */
                                                JSONArray jsonArrayOfDistrict = jsonArrayOfCity.getJSONObject(outTmp).getJSONArray("district");
                                                JSONObject jsonObjectOfCity = jsonArrayOfCity.getJSONObject(0);
                                                final String[] arrayOfDistrict = new String[jsonArrayOfDistrict.length()];

                                                for (int inTmp = 0; inTmp < jsonArrayOfDistrict.length(); inTmp++) {
                                                    arrayOfDistrict[inTmp] = jsonArrayOfDistrict.getJSONObject(inTmp).getString("district");
                                                }
                                                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, arrayOfDistrict);
                                                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                                spinnerOfArea.setAdapter(adapter);
                                                spinnerOfArea.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                    @Override
                                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                        EditText editText = (EditText) findViewById(R.id.tvOfCity);
                                                        editText.setText(arrayOfDistrict[position]);
                                                        /**
                                                         Intent intent = new Intent(MainActivity.this, ShowWeatherActivity.class);
                                                         //获取传递城市名\
                                                         intent.putExtra(EXTRA_MESSAGE,arrayOfDistrict[position]);
                                                         /////////////////////////////////
                                                         startActivity(intent);*/
                                                    }

                                                    @Override
                                                    public void onNothingSelected(AdapterView<?> parent) {

                                                    }
                                                });
                                                break;
                                            }
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });


                            break;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //nothing to do
            }
        });
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
