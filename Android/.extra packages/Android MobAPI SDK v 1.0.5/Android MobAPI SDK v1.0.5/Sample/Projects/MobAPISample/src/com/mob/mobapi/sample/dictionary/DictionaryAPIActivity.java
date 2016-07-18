/*
 * 官网地站:http://www.mob.com
 * 技术支持QQ: 4006852216
 * 官方微信:ShareSDK   （如果发布新版本的话，我们将会第一时间通过微信将版本更新内容推送给您。如果使用过程中有任何问题，也可以通过微信与我们取得联系，我们将会在24小时内给予回复）
 *
 * Copyright (c) 2013年 mob.com. All rights reserved.
 */

package com.mob.mobapi.sample.dictionary;

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
import com.mob.mobapi.apis.Dictionary;
import com.mob.mobapi.sample.R;

public class DictionaryAPIActivity extends Activity implements OnClickListener, APICallback {
	private EditText etDictionary;
	private TextView tvName;
	private TextView tvPinyin;
	private TextView tvWubi;
	private TextView tvBushou;
	private TextView tvBihuaWithBushou;
	private TextView tvBrief;
	private TextView tvDetail;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dictionary);
		etDictionary  = forceCast(findViewById(R.id.etDictionary));
		tvName   = forceCast(findViewById(R.id.tvName));
		tvPinyin = forceCast(findViewById(R.id.tvPinyin));
		tvWubi   = forceCast(findViewById(R.id.tvWubi));
		tvBushou = forceCast(findViewById(R.id.tvBushou));
		tvBrief  = forceCast(findViewById(R.id.tvBrief));
		tvDetail = forceCast(findViewById(R.id.tvDetail));
		tvBihuaWithBushou = forceCast(findViewById(R.id.tvBihuaWithBushou));
		etDictionary.setText("游");
		findViewById(R.id.btnSearch).setOnClickListener(this);
	}

	public void onClick(View v) {
		Dictionary api = (Dictionary) MobAPI.getAPI(Dictionary.NAME);
		api.queryDictionary(etDictionary.getText().toString().trim(), this);
	}

	public void onSuccess(API api, int action, Map<String, Object> result) {
		HashMap<String, Object> res = forceCast(result.get("result"));
		tvName.setText(com.mob.tools.utils.R.toString(res.get("name")));
		tvPinyin.setText(com.mob.tools.utils.R.toString(res.get("pinyin")));
		tvWubi.setText(com.mob.tools.utils.R.toString(res.get("wubi")));
		tvBushou.setText(com.mob.tools.utils.R.toString(res.get("bushou")));
		tvBihuaWithBushou.setText(com.mob.tools.utils.R.toString(res.get("bihuaWithBushou")));
		tvBrief.setText(com.mob.tools.utils.R.toString(res.get("brief")));
		tvDetail.setText(com.mob.tools.utils.R.toString(res.get("detail")));
	}

	public void onError(API api, int action, Throwable details) {
		details.printStackTrace();
		Toast.makeText(this, R.string.error_raise, Toast.LENGTH_SHORT).show();
	}
}
