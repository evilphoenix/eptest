package com.aq.util;

import java.util.LinkedList;
import java.util.List;
import android.app.Application;
import android.app.Activity;
import com.baidu.location.*;
import com.baidu.mapapi.MKGeneralListener;
import com.baidu.mapapi.map.MKEvent;

import android.widget.Toast;

public class EpApplication extends Application {
	private List<Activity> activityList = new LinkedList<Activity>();
	private static EpApplication instance;
	
	/*add by zouna*/
	public boolean m_bKeyRight = true;
	public LocationClient mLocationClient = null;
	private  String mStrKey = "542C9FAB8090895E84F0BEA0DEBA5BE2C594A932";
	/*add by zouna*/
	
	//单例模式中获取唯一的MyApplication实例
	public static EpApplication getInstance() {
		if (null == instance) {
			instance = new EpApplication();
		}
		return instance;
	}

	// 添加Activity到容器中
	public void addActivity(Activity activity) {
		activityList.add(activity);
	}

	// 遍历所有Activity并finish
	public void exit() {
		for (Activity activity : activityList) {
			activity.finish();
		}
		System.exit(0);
	}
	
	/*add by zouna*/
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		mLocationClient = new LocationClient(this);
		//mLocationClient.registerLocationListener( myListener );
		super.onCreate();
	}
	
	public  String GetKey()
	{
		return this.mStrKey;
	}

    //常用事件监听，用来处理通常的网络错误，授权验证错误等
    public static class MyGeneralListener implements MKGeneralListener {
  	  
  	  public void onGetNetworkState(int iError) {
  	      if (iError == MKEvent.ERROR_NETWORK_CONNECT) {
  	          Toast.makeText(EpApplication.getInstance().getApplicationContext(), "您的网络出错啦！",
  	              Toast.LENGTH_LONG).show();
  	      }
  	      else if (iError == MKEvent.ERROR_NETWORK_DATA) {
  	          Toast.makeText(EpApplication.getInstance().getApplicationContext(), "输入正确的检索条件！",
  	                  Toast.LENGTH_LONG).show();
  	      }
  	      // ...
  	  }

  	  
  	  public void onGetPermissionState(int iError) {
  	      if (iError ==  MKEvent.ERROR_PERMISSION_DENIED) {
  	          //授权Key错误：
  	          Toast.makeText(EpApplication.getInstance().getApplicationContext(), 
  	                  "请在 DemoApplication.java文件输入正确的授权Key！", Toast.LENGTH_LONG).show();
  	          EpApplication.getInstance().m_bKeyRight = false;
  	      }
  	  }
  	}
    /*add by zouna*/
}
