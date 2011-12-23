package com.newhope.study;

import java.util.ArrayList;

import com.newhope.study.R.id;

import android.app.Activity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.util.Log;
import android.content.*;

public class ActivityTransDataActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
	private final String TAG = "Activity Example";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button btnPassDataByIndentData = (Button)this.findViewById(id.pass_data_by_indent);
        Button btnPassDataByAppData = (Button)this.findViewById(id.pass_data_by_app_data);
        Button btnAbout = (Button)this.findViewById(id.about);
        Button btnExit = (Button)this.findViewById(id.exit_app);
        
        btnPassDataByIndentData.setOnClickListener(this);
        btnPassDataByAppData.setOnClickListener(this);
        btnAbout.setOnClickListener(this);
        btnExit.setOnClickListener(this);
    }
    
    private void passDataByIndentExample() {
    	Log.d(TAG, "-->passDataByIndentExample");
    	Intent i = new Intent(this, ActivityPassData.class);
    	ArrayList<DataToPass> passDatas = new ArrayList<DataToPass>();
    	
    	for (int j=0; j<1000; j++) {
    		String pair = String.format("%03d", j);
        	String value = String.format("value %03d", j);
    		DataToPass data = new DataToPass(pair, value);
    		passDatas.add(data);
    	}
    	
    	i.putExtra("data", passDatas);
    	i.putExtra(TransType.MSG_TYPE, TransType.SEND_DATA_INTENT);
    	startActivity(i);
    }
    
    private void passDataByAppDataExample() {
    	Log.d(TAG, "-->passDataByAppDataExample");
    	Intent i = new Intent(this, ActivityPassData.class);
    	i.putExtra(TransType.MSG_TYPE,TransType.SEND_DATA_APPLI);
    	startActivity(i);
    }
    
    public void onClick(View v) {
    	switch(v.getId()) {
    	case id.pass_data_by_indent:
    		this.passDataByIndentExample();
    		break;
    		
    	case id.pass_data_by_app_data:
    		this.passDataByAppDataExample();
    		break;
    		
    	case id.about:
    		Intent i = new Intent(this, About.class);
    		startActivity(i);
    		break;
    		
    	case id.exit_app:
    		this.finish();
    		break;
    	default:
    		break;
    	}
    }
}