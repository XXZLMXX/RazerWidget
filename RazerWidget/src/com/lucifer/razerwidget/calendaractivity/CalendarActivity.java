package com.lucifer.razerwidget.calendaractivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.lucifer.razerwidget.R;



public class CalendarActivity extends Activity
{
	
	Button btn_calender1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.aty_calendar);
	
		initView();
		setListener();
		
		
	}
	
	
	
	private void initView()
	{
		btn_calender1 = (Button) findViewById(R.id.btn_calender1);
	}
	
	
	
	private void setListener()
	{
		btn_calender1.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View arg0)
			{
				// TODO Auto-generated method stub
				Intent intent = new Intent(CalendarActivity.this,SampleTimesSquareActivity.class);
				startActivity(intent);
			}
		});
	}
	
}
