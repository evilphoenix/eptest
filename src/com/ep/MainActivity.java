package com.ep;

import com.aq.R;
import com.ep.util.AndroidUtil;

import android.os.Bundle;
import android.view.KeyEvent;

public class MainActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		//跳转到主操作界面
		//this.gotoNextActivity(null, MainActivity.class);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode == KeyEvent.KEYCODE_BACK){
			AndroidUtil.dialog_Exit(this, "1");
		}
		
		return super.onKeyDown(keyCode, event);
	}
	
	
}
