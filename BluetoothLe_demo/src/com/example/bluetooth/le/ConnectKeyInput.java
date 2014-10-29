package com.example.bluetooth.le;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ConnectKeyInput extends Activity{

	public static final String EXTRAS_DEVICE_NAME = "DEVICE_NAME";
    public static final String EXTRAS_DEVICE_ADDRESS = "DEVICE_ADDRESS";
    public static final String EXTRAS_DEVICE_CONNECTKEY = "CONNECT_KEY";
    static String mDeviceConnectkey = null;
    
	private String mDeviceName;
    private String mDeviceAddress;
    
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.connect_blepwd);
	
		final Intent intent = getIntent();
        mDeviceName = intent.getStringExtra(EXTRAS_DEVICE_NAME);
        mDeviceAddress = intent.getStringExtra(EXTRAS_DEVICE_ADDRESS);
                
       // mDeviceConnectkey = 
        final EditText myConnectkey = (EditText)findViewById(R.id.mybleConnectkey);
        final Button myEnterButton = (Button)findViewById(R.id.myEnter);
        
       // Intent intentconnecykey = new Intent(this,DeviceControlActivity.class);
    	//intentconnecykey.setClass(ConnectKeyInput.this, DeviceControlActivity.class);
    	//startActivity(intent);
    	
        myEnterButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
		        //mDeviceConnectkey = "0" + myConnectkey.getText().toString() + "000";
				//mDeviceConnectkey = null;
				
		        if (myConnectkey.getText().toString().isEmpty())
		        {
		        	Toast.makeText(getApplicationContext(), "Input Key",Toast.LENGTH_SHORT).show();
		        }
		        else
		        {
		        	mDeviceConnectkey = "0" + myConnectkey.getText().toString() + "000";
		        	//Intent intentconnecykey = new Intent();
		        	//intentconnecykey.setClassName(this, ConnectKeyInput.class);
		        	final Intent intentconnecykey = new Intent(ConnectKeyInput.this, DeviceControlActivity.class);
		        	intentconnecykey.putExtra(DeviceControlActivity.EXTRAS_DEVICE_NAME, mDeviceName);
		        	intentconnecykey.putExtra(DeviceControlActivity.EXTRAS_DEVICE_ADDRESS, mDeviceAddress);
		        	//intentconnecykey.putExtra("CONNECT_KEY", mDeviceConnectkey);
		        	startActivity(intentconnecykey);
		        }
			}
		});
        

        
	}
	

}
