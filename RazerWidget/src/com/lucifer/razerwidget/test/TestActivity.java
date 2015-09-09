package com.lucifer.razerwidget.test;

import com.lucifer.razerwidget.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;



public class TestActivity extends Activity implements OnClickListener
{
	Button btn_mytextview_test, btn_colorfilter_test, btn_Xfermode_test;
	

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.aty_test);
		
		
		btn_mytextview_test = (Button) findViewById(R.id.btn_mytextview_test);
		btn_colorfilter_test = (Button) findViewById(R.id.btn_colorfilter_test);
		btn_Xfermode_test = (Button) findViewById(R.id.btn_Xfermode_test);
		
		btn_mytextview_test.setOnClickListener(this);
		btn_colorfilter_test.setOnClickListener(this);
		btn_Xfermode_test.setOnClickListener(this);
	}


	
	
	@Override
	public void onClick(View v)
	{
		// TODO Auto-generated method stub
		switch (v.getId())
		{
		case R.id.btn_mytextview_test:
			Intent intent1 = new Intent(TestActivity.this, MyTextViewActivity.class);
			startActivity(intent1);
			break;
			
		case R.id.btn_colorfilter_test:
			Intent intent2 = new Intent(TestActivity.this, ColorFilterActivity.class);
			startActivity(intent2);	
			break;
					
		case R.id.btn_Xfermode_test:
			Intent intent3 = new Intent(TestActivity.this, XfermodeActivity.class);
			startActivity(intent3);	
			break;

		default:
			break;
		}
	}
	
}
