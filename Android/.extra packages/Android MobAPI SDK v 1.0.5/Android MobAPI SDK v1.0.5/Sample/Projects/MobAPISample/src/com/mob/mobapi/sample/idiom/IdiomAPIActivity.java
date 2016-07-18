/*
 * 官网地站:http://www.mob.com
 * 技术支持QQ: 4006852216
 * 官方微信:ShareSDK   （如果发布新版本的话，我们将会第一时间通过微信将版本更新内容推送给您。如果使用过程中有任何问题，也可以通过微信与我们取得联系，我们将会在24小时内给予回复）
 *
 * Copyright (c) 2013年 mob.com. All rights reserved.
 */

package com.mob.mobapi.sample.idiom;

import static com.mob.tools.utils.R.forceCast;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mob.mobapi.API;
import com.mob.mobapi.APICallback;
import com.mob.mobapi.MobAPI;
import com.mob.mobapi.apis.Idiom;
import com.mob.mobapi.sample.R;

public class IdiomAPIActivity extends Activity implements OnClickListener, APICallback {
	private EditText etIdiom;
	private TextView tvName;
	private TextView tvPinyin;
	private TextView tvPretation;
	private TextView tvSource;
	private TextView tvSample;
	private TextView tvSampleFrom;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_idiom);
		etIdiom      = forceCast(findViewById(R.id.etIdiom));
		tvName       = forceCast(findViewById(R.id.tvName));
		tvPinyin     = forceCast(findViewById(R.id.tvPinyin));
		tvPretation  = forceCast(findViewById(R.id.tvPretation));
		tvSource     = forceCast(findViewById(R.id.tvSource));
		tvSample     = forceCast(findViewById(R.id.tvSample));
		tvSampleFrom = forceCast(findViewById(R.id.tvSampleFrom));
		etIdiom.setText("狐假虎威");
		findViewById(R.id.btnSearch).setOnClickListener(this);
	}

	public void onClick(View v) {
		Idiom api = (Idiom) MobAPI.getAPI(Idiom.NAME);
		api.queryIdiom(etIdiom.getText().toString().trim(), this);
	}

	public void onSuccess(API api, int action, Map<String, Object> result) {
		HashMap<String, Object> res = forceCast(result.get("result"));
		tvName.setText(com.mob.tools.utils.R.toString(res.get("name")));
		tvPinyin.setText(com.mob.tools.utils.R.toString(res.get("pinyin")));
		tvPretation.setText(com.mob.tools.utils.R.toString(res.get("pretation")));
		tvSource.setText(com.mob.tools.utils.R.toString(res.get("source")));
		tvSample.setText(com.mob.tools.utils.R.toString(res.get("sample")));
		tvSampleFrom.setText(com.mob.tools.utils.R.toString(res.get("sampleFrom")));
	}

	public void onError(API api, int action, Throwable details) {
		details.printStackTrace();
		Toast.makeText(this, R.string.error_raise, Toast.LENGTH_SHORT).show();
	}
}
