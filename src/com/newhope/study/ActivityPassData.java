package com.newhope.study;

import java.util.ArrayList;
import com.newhope.study.R.id;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.util.*;

public class ActivityPassData extends Activity{
    /** Called when the activity is first created. */
	private final String TAG = "ActivityPassData";
	
	private DataAdapter adapter;
	
    @SuppressWarnings("unchecked")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_data);
        TextView tv = (TextView)this.findViewById(id.textView1);
        
        Intent i = this.getIntent();
        ArrayList<DataToPass> Datas = null;
        int flags = i.getIntExtra(TransType.MSG_TYPE, 0x00);
        switch(flags) {
        case TransType.SEND_DATA_INTENT:
        	tv.setText("Pass Data By Intent Extra");
        	Datas = (ArrayList<DataToPass>)i.getSerializableExtra("data");
        	break;
        case TransType.SEND_DATA_APPLI:
        	MyApplication app = (MyApplication)this.getApplication();
        	if (app != null) {
        		tv.setText("Pass Data By Application Member");
        		Datas = app.getDataToPass();
        	}
        	break;
        default:
        		return;
        }
        
        if (Datas != null) {
        	this.adapter = new DataAdapter(this, R.layout.intent_data_item, R.id.list_item_text, Datas);
        	ListView listView = (ListView)this.findViewById(id.data_list);
        	listView.setAdapter(adapter);
        }
    }
    
    class DataAdapter extends ArrayAdapter<DataToPass> {
    	private ArrayList<DataToPass> dataLists;
    	
		public DataAdapter(Context context, int resource, int textViewResourceId,
				ArrayList<DataToPass> objects) {
			super(context, resource, textViewResourceId, objects);
			this.dataLists = (ArrayList<DataToPass>)objects;
		}
    	
		public View getView(int position, View convertView, ViewGroup parent) {
			View listItem = super.getView(position, convertView, parent);
			TextView tv = (TextView)listItem.findViewById(id.list_item_text);
			DataToPass data = (DataToPass)this.dataLists.get(position);
			if (data != null) {
				tv.setText(data.getPair() + new String(":") + data.getValue());
				Log.e(TAG, "-->getView:" + String.format("pos:%d", position));
			}
			return listItem;
		}
    }
}
