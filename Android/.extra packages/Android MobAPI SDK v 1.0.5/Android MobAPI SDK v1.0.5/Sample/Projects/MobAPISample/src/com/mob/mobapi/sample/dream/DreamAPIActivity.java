/*
 * 官网地站:http://www.mob.com
 * 技术支持QQ: 4006852216
 * 官方微信:ShareSDK   （如果发布新版本的话，我们将会第一时间通过微信将版本更新内容推送给您。如果使用过程中有任何问题，也可以通过微信与我们取得联系，我们将会在24小时内给予回复）
 *
 * Copyright (c) 2013年 mob.com. All rights reserved.
 */

package com.mob.mobapi.sample.dream;

import static com.mob.tools.utils.R.forceCast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.mob.mobapi.API;
import com.mob.mobapi.APICallback;
import com.mob.mobapi.MobAPI;
import com.mob.mobapi.apis.Dream;
import com.mob.mobapi.sample.R;

public class DreamAPIActivity extends Activity implements OnClickListener, APICallback {
	private static final int pageSize = 20; // max is 20
	private ListView lvDream;
	private EditText etDream;
	private int pageIndex;
	private int total;
	private ArrayList<HashMap<String, Object>> dreamList;
	private DreamSimpleAdapter adapter;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dream);
		lvDream = forceCast(findViewById(R.id.lvDream));
		etDream = forceCast(findViewById(R.id.etDream));
		etDream.setText(R.string.dream_api_example);
		findViewById(R.id.btnSearch).setOnClickListener(this);

		dreamList = new ArrayList<HashMap<String,Object>>();
		adapter = new DreamSimpleAdapter(this, dreamList);
		lvDream.setAdapter(adapter);
	}

	public void onClick(View v) {
		pageIndex = 0;
		dreamList.clear();
		adapter.notifyDataSetChanged();
		queryDream();
	}

	private void queryDream() {
		Dream api = forceCast(MobAPI.getAPI(Dream.NAME));
		String keyword = etDream.getText().toString().trim();
		api.queryDream(keyword, pageIndex + 1, pageSize, this);
	}

	public void onSuccess(API api, int action, Map<String, Object> result) {
		HashMap<String, Object> res = forceCast(result.get("result"));
		total = Integer.parseInt(com.mob.tools.utils.R.toString(res.get("total")));
		ArrayList<HashMap<String, Object>> list = forceCast(res.get("list"));
		if (null != list) {
			dreamList.addAll(list);
			adapter.notifyDataSetChanged();
		}
		++pageIndex;
	}

	public void onError(API api, int action, Throwable details) {
		details.printStackTrace();
		Toast.makeText(this, R.string.error_raise, Toast.LENGTH_SHORT).show();
	}

	private class DreamSimpleAdapter extends BaseAdapter {
		private LayoutInflater mInflater;
		private ArrayList<HashMap<String, Object>> list;

		DreamSimpleAdapter(Context context, ArrayList<HashMap<String, Object>> res) {
			mInflater = LayoutInflater.from(context);
			list = res;
		}

		public int getCount() {
			if (list.size() == 0) {
				return 0;
			} else if (list.size() == total) {
				return list.size();
			} else {
				return list.size() + 1;
			}
		}

		public Object getItem(int position) {
			return list.get(position);
		}

		public long getItemId(int position) {
			return 0;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			if (position < list.size()) {
				return getView1(position, convertView, parent);
			} else {
				return getView2(convertView, parent);
			}
		}

		private View getView1(int position, View convertView, ViewGroup parent) {
			convertView = mInflater.inflate(R.layout.view_dream_item, null);
			TextView tvName  = forceCast(convertView.findViewById(R.id.tvName));
			TextView tvDetail = forceCast(convertView.findViewById(R.id.tvDetail));

			HashMap<String, Object> res = list.get(position);
			tvName.setText(com.mob.tools.utils.R.toString(res.get("name")));
			tvDetail.setText(com.mob.tools.utils.R.toString(res.get("detail")));
			return convertView;
		}

		private View getView2(View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = new ProgressBar(parent.getContext());
			}

			if (list.size() < total) {
				convertView.setVisibility(View.VISIBLE);
				queryDream();
			} else {
				convertView.setVisibility(View.GONE);
			}

			return convertView;
		}
	}
}
