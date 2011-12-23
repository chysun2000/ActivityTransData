package com.newhope.study;

import java.util.ArrayList;
import android.app.Application;
import android.util.*;

public class MyApplication extends Application {
	private final String TAG = "MyApplication";
	private ArrayList<DataToPass> dataToPass;
	
	private void initData() {
		Log.d(TAG, "-->initData");
		dataToPass = new ArrayList<DataToPass>();
		for (int i=2000; i<3000;i++) {
			String pair = String.format("%03d", i);
        	String value = String.format("value %03d", i);
    		DataToPass data = new DataToPass(pair, value);
    		dataToPass.add(data);
		}
	}
	
	public void onCreate() {
		Log.d(TAG,"-->onCreate");
		super.onCreate();
		this.initData();
	}
	
	public ArrayList<DataToPass> getDataToPass() {
		Log.d(TAG, "-->getDataToPass");
		return this.dataToPass;
	}
}
