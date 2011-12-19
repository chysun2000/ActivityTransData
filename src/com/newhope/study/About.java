package com.newhope.study;

import com.newhope.study.R.id;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.util.Log;

public class About extends Activity implements OnClickListener {
	private final String TAG = "About";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        
        View btnClose = (View)this.findViewById(id.close_about);
        btnClose.setOnClickListener(this);
        
        Log.e(TAG, "-->onCreate");
    }
    
	public void onClick(View v) {
		if (v.getId() == id.close_about) {
			this.finish();
			Log.e(TAG, "-->Click Close");
		}
	}

}
