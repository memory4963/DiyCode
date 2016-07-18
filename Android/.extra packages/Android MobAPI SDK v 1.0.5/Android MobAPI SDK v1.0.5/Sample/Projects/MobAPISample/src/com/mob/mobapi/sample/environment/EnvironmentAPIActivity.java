package com.mob.mobapi.sample.environment;

import static com.mob.tools.utils.R.forceCast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mob.mobapi.API;
import com.mob.mobapi.APICallback;
import com.mob.mobapi.MobAPI;
import com.mob.mobapi.apis.Environment;
import com.mob.mobapi.sample.R;

public class EnvironmentAPIActivity extends Activity implements OnClickListener, APICallback {
	private EditText etCity;
	private TextView tvProvince;
	private TextView tvCity;
	private TextView tvDistrict;
	private TextView tvAqi;
	private TextView tvNo2;
	private TextView tvPm10;
	private TextView tvPm25;
	private TextView tvQuality;
	private TextView tvSo2;
	private LinearLayout llHourData;
	private LinearLayout llFetureData;
	private TextView tvUpdateTime;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_environment);
		etCity     = forceCast(findViewById(R.id.etCity));
		tvProvince = forceCast(findViewById(R.id.tvProvince));
		tvCity     = forceCast(findViewById(R.id.tvCity));
		tvDistrict = forceCast(findViewById(R.id.tvDistrict));
		tvAqi  = forceCast(findViewById(R.id.tvAqi));
		tvNo2  = forceCast(findViewById(R.id.tvNo2));
		tvPm10 = forceCast(findViewById(R.id.tvPm10));
		tvPm25 = forceCast(findViewById(R.id.tvPm25));
		tvQuality = forceCast(findViewById(R.id.tvQuality));
		tvSo2     = forceCast(findViewById(R.id.tvSo2));
		llHourData   = forceCast(findViewById(R.id.llHourData));
		llFetureData = forceCast(findViewById(R.id.llFetureData));
		tvUpdateTime = forceCast(findViewById(R.id.tvUpdateTime));
		findViewById(R.id.btnSearch).setOnClickListener(this);
	}

	public void onClick(View v) {
		// 获取API实例，请求空气质量信息
		Environment api = forceCast(MobAPI.getAPI(Environment.NAME));
		api.query(etCity.getText().toString().trim(), null, this);
	}

	public void onSuccess(API api, int action, Map<String, Object> result) {
		@SuppressWarnings("unchecked")
		ArrayList<HashMap<String, Object>> list = (ArrayList<HashMap<String, Object>>) result.get("result");
		HashMap<String, Object> data = list.get(0);
		llHourData.setVisibility(View.GONE);
		((LinearLayout) llHourData.getChildAt(2)).removeAllViews();
		llFetureData.setVisibility(View.GONE);
		((LinearLayout) llFetureData.getChildAt(2)).removeAllViews();
		updateUI(data);
	}

	public void onError(API api, int action, Throwable details) {
		details.printStackTrace();
		Toast.makeText(this, R.string.error_raise, Toast.LENGTH_SHORT).show();
	}

	private void updateUI(HashMap<String, Object> result) {
		tvProvince.setText(com.mob.tools.utils.R.toString(result.get("province")));
		tvCity.setText(com.mob.tools.utils.R.toString(result.get("city")));
		tvDistrict.setText(com.mob.tools.utils.R.toString(result.get("district")));
		tvAqi.setText(com.mob.tools.utils.R.toString(result.get("aqi")));
		tvNo2.setText(com.mob.tools.utils.R.toString(result.get("no2")));
		tvPm10.setText(com.mob.tools.utils.R.toString(result.get("pm10")));
		tvPm25.setText(com.mob.tools.utils.R.toString(result.get("pm25")));
		tvQuality.setText(com.mob.tools.utils.R.toString(result.get("quality")));
		tvSo2.setText(com.mob.tools.utils.R.toString(result.get("so2")));
		tvUpdateTime.setText(com.mob.tools.utils.R.toString(result.get("updateTime")));

		@SuppressWarnings("unchecked")
		ArrayList<HashMap<String, Object>> hourData = (ArrayList<HashMap<String,Object>>) result.get("hourData");
		if (hourData != null && hourData.size() > 0) {
			llHourData.setVisibility(View.VISIBLE);
			LinearLayout llList = (LinearLayout) llHourData.getChildAt(2);
			for (HashMap<String, Object> hour : hourData) {
				View llHour = View.inflate(this, R.layout.view_environment_hour, null);
				TextView tvTime = (TextView) llHour.findViewById(R.id.tvTime);
				String dateTime = com.mob.tools.utils.R.toString(hour.get("dateTime"));
				tvTime.setText(dateTime.split(" ")[1]);
				TextView tvAqi = (TextView) llHour.findViewById(R.id.tvAqi);
				tvAqi.setText(com.mob.tools.utils.R.toString(hour.get("aqi")));
				llList.addView(llHour);
			}
		}

		@SuppressWarnings("unchecked")
		ArrayList<HashMap<String, Object>> fetureData = (ArrayList<HashMap<String,Object>>) result.get("fetureData");
		if (fetureData != null && fetureData.size() > 0) {
			llFetureData.setVisibility(View.VISIBLE);
			LinearLayout llList = (LinearLayout) llFetureData.getChildAt(2);
			for (HashMap<String, Object> data : fetureData) {
				View llDate = View.inflate(this, R.layout.view_environment_hour, null);
				TextView tvTime = (TextView) llDate.findViewById(R.id.tvTime);
				tvTime.setText(com.mob.tools.utils.R.toString(data.get("date")));
				TextView tvAqi = (TextView) llDate.findViewById(R.id.tvAqi);
				String aqi = com.mob.tools.utils.R.toString(data.get("aqi"));
				String quality = com.mob.tools.utils.R.toString(data.get("quality"));
				tvAqi.setText(aqi + " (" + quality + ")");
				llList.addView(llDate);
			}
		}
	}

}
