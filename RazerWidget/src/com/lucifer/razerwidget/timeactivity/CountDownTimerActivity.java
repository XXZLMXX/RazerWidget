package com.lucifer.razerwidget.timeactivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.lucifer.razerwidget.R;

public class CountDownTimerActivity extends Activity
{

	TimeCount time;
	TextView tv_countdowntimer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.aty_countdowntimer);
		
		tv_countdowntimer = (TextView) findViewById(R.id.tv_countdowntimer);
		tv_countdowntimer.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View arg0)
			{
				// TODO Auto-generated method stub
				time = new TimeCount(60000, 1000);// 构造CountDownTimer对象
				time.start();// 开始计时
			}
		});
	}

	
	
	/* 定义一个倒计时的内部类 */
	class TimeCount extends CountDownTimer
	{

		public TimeCount(long millisInFuture, long countDownInterval)
		{
			super(millisInFuture, countDownInterval);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onFinish()
		{
			// TODO Auto-generated method stub
			tv_countdowntimer.setText("重新计时");
			tv_countdowntimer.setClickable(true);
		}

		@Override
		public void onTick(long millisUntilFinished)
		{
			// TODO Auto-generated method stub
			tv_countdowntimer.setClickable(false);
			tv_countdowntimer.setText(millisUntilFinished / 1000 + "秒");
		}

	}
}
