package com.lucifer.razerwidget.swipeoutactivity;

import com.lucifer.razerwidget.R;
import com.lucifer.razerwidget.swipeoutactivity.slidingmenu.SlidingActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;



public class SwipeoutActivity extends Activity implements OnClickListener
{
	Button btn_swipecard_swipeout, btn_slidingmenu_swipeout;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.aty_swipeout);
		
		btn_swipecard_swipeout = (Button) findViewById(R.id.btn_swipecard_swipeout);
		btn_slidingmenu_swipeout = (Button) findViewById(R.id.btn_slidingmenu_swipeout);
		
		btn_swipecard_swipeout.setOnClickListener(this);
		btn_slidingmenu_swipeout.setOnClickListener(this);
	}



	@Override
	public void onClick(View v)
	{
		// TODO Auto-generated method stub
		switch (v.getId())
		{
		case R.id.btn_swipecard_swipeout:
			Intent intent1 = new Intent(SwipeoutActivity.this, SwipeCardActivity.class);
			startActivity(intent1);
			break;
			
			
		case R.id.btn_slidingmenu_swipeout:
			Intent intent2 = new Intent(SwipeoutActivity.this, SlidingActivity.class);
			startActivity(intent2);
			break;

		default:
			break;
		}
	}

}
