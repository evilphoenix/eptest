package com.ep;

import java.util.Date;

import com.ep.util.EpApplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class BaseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		EpApplication.getInstance().addActivity(this);
	}

	/**
	 * 初始化公共参数的方法
	 */
	protected void initial() {
		Log.i(this.toString(),"base initial");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		return super.onCreateOptionsMenu(menu);
	}

	/**
	 * 将参数传送到下一个界面并跳转
	 * 
	 * @param bdl
	 *            参数
	 * @param nextActivity
	 *            下一个activity
	 */
	public void gotoNextActivity(Bundle bdl, Class<?> nextActivity) {
		Intent intent = new Intent();
		if (null != bdl) {
			intent.putExtras(bdl);
		}
		intent.setClass(this, nextActivity);
		this.startActivity(intent);
	}

}
