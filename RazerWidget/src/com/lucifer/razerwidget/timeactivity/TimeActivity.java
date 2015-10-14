package com.lucifer.razerwidget.timeactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.lucifer.razerwidget.R;
import com.lucifer.razerwidget.timeactivity.allpicker.AllPickerActivity;

public class TimeActivity extends Activity implements OnClickListener
{
	Button btn_timepicker1;
	Button btn_countdowntimer;
	Button btn_dateandtimepicker;
	

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.aty_time);

		
		btn_timepicker1 = (Button)findViewById(R.id.btn_timepicker1);
		btn_countdowntimer = (Button)findViewById(R.id.btn_countdowntimer);
		btn_dateandtimepicker = (Button)findViewById(R.id.btn_dateandtimepicker);
		
		btn_timepicker1.setOnClickListener(this);
		btn_countdowntimer.setOnClickListener(this);
		btn_dateandtimepicker.setOnClickListener(this);
	}




	@Override
	public void onClick(View arg0)
	{
		// TODO Auto-generated method stub
		switch (arg0.getId())
		{
		case R.id.btn_timepicker1:
			
			Intent intent = new Intent(TimeActivity.this,TimePickerActivity.class);
			startActivity(intent);
			
			break;

		case R.id.btn_countdowntimer:
			
			Intent intent2 = new Intent(TimeActivity.this,CountDownTimerActivity.class);
			startActivity(intent2);
			
			break;
			
		case R.id.btn_dateandtimepicker:
			
			Intent intent3 = new Intent(TimeActivity.this,AllPickerActivity.class);
			startActivity(intent3);
			
			break;
		default:
			break;
		}
		
	}
}
