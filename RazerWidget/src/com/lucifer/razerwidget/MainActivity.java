package com.lucifer.razerwidget;

import com.lucifer.razerwidget.FlipPageActivity.FlipPageActivity;
import com.lucifer.razerwidget.calendaractivity.CalendarActivity;
import com.lucifer.razerwidget.dialogpopupwindow.DialogPopupwindowActivity;
import com.lucifer.razerwidget.imageviewactivity.ImageViewActivity;
import com.lucifer.razerwidget.progressbaractivity.ProgressBarActivity;
import com.lucifer.razerwidget.recyclerviewactivity.RecyclerViewActivity;
import com.lucifer.razerwidget.relationmenuactivity.RelationMenuActivity;
import com.lucifer.razerwidget.reportactivity.ReportActivity;
import com.lucifer.razerwidget.satelliteactivity.SatelliteActivity;
import com.lucifer.razerwidget.scrolllistgridviewactivity.ScrollListGridViewActivity;
import com.lucifer.razerwidget.swipeoutactivity.SwipeoutActivity;
import com.lucifer.razerwidget.test.TestActivity;
import com.lucifer.razerwidget.textview.TextViewActivity;
import com.lucifer.razerwidget.timeactivity.TimeActivity;
import com.lucifer.razerwidget.viewpageractivity.ViewPagerActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;


public class MainActivity extends Activity implements OnClickListener
{
	TextView tv1,tv4,tv5,tv6,tv7,tv8,tv9,tv10,tv11,tv12,tv13,tv14,tv15,tv16,tv17;
	

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aty_main);
		
		initView();
	}
	
	
	
	private void initView()
	{
		tv1 = (TextView) findViewById(R.id.tv1);
		tv4 = (TextView) findViewById(R.id.tv4);
		tv5 = (TextView) findViewById(R.id.tv5);
		tv6 = (TextView) findViewById(R.id.tv6);
		tv7 = (TextView) findViewById(R.id.tv7);
		tv8 = (TextView) findViewById(R.id.tv8);
		tv9 = (TextView) findViewById(R.id.tv9);
		tv10 = (TextView) findViewById(R.id.tv10);
		tv11 = (TextView) findViewById(R.id.tv11);
		tv12 = (TextView) findViewById(R.id.tv12);
		tv13 = (TextView) findViewById(R.id.tv13);
		tv14 = (TextView) findViewById(R.id.tv14);
		tv15 = (TextView) findViewById(R.id.tv15);
		tv16 = (TextView) findViewById(R.id.tv16);
		tv17 = (TextView) findViewById(R.id.tv17);
		
		tv1.setOnClickListener(this);
		tv4.setOnClickListener(this);
		tv5.setOnClickListener(this);
		tv6.setOnClickListener(this);
		tv7.setOnClickListener(this);
		tv8.setOnClickListener(this);
		tv9.setOnClickListener(this);
		tv10.setOnClickListener(this);
		tv11.setOnClickListener(this);
		tv12.setOnClickListener(this);
		tv13.setOnClickListener(this);
		tv14.setOnClickListener(this);
		tv15.setOnClickListener(this);
		tv16.setOnClickListener(this);
		tv17.setOnClickListener(this);
	}

	

	@Override
	public void onClick(View v)
	{
		// TODO Auto-generated method stub
		switch (v.getId())
		{
		case R.id.tv1:
			Intent intent1 = new Intent(MainActivity.this, ScrollListGridViewActivity.class);
			startActivity(intent1);
			break;
			
		case R.id.tv4:
			Intent intent4 = new Intent(MainActivity.this, ImageViewActivity.class);
			startActivity(intent4);
			break;

		case R.id.tv5:
			Intent intent5 = new Intent(MainActivity.this, ViewPagerActivity.class);
			startActivity(intent5);
			break;

		case R.id.tv6:
			Intent intent6 = new Intent(MainActivity.this, DialogPopupwindowActivity.class);
			startActivity(intent6);
			break;

		case R.id.tv7:
			Intent intent7 = new Intent(MainActivity.this, ProgressBarActivity.class);
			startActivity(intent7);
			break;

		case R.id.tv8:
			Intent intent8 = new Intent(MainActivity.this, CalendarActivity.class);
			startActivity(intent8);
			break;

		case R.id.tv9:
			Intent intent9 = new Intent(MainActivity.this, TimeActivity.class);
			startActivity(intent9);
			break;

		case R.id.tv10:
			Intent intent10 = new Intent(MainActivity.this, RelationMenuActivity.class);
			startActivity(intent10);
			break;
			
		case R.id.tv11:
			Intent intent11 = new Intent(MainActivity.this, SwipeoutActivity.class);
			startActivity(intent11);
			break;
			
		case R.id.tv12:
			Intent intent12 = new Intent(MainActivity.this, FlipPageActivity.class);
			startActivity(intent12);
			break;
			
		case R.id.tv13:
			Intent intent13 = new Intent(MainActivity.this, SatelliteActivity.class);
			startActivity(intent13);
			break;
			
		case R.id.tv14:
			Intent intent14 = new Intent(MainActivity.this, ReportActivity.class);
			startActivity(intent14);
			break;
			
		case R.id.tv15:
			Intent intent15 = new Intent(MainActivity.this, TextViewActivity.class);
			startActivity(intent15);
			break;
			
		case R.id.tv16:
			Intent intent16 = new Intent(MainActivity.this, RecyclerViewActivity.class);
			startActivity(intent16);
			break;
			
		case R.id.tv17:
			Intent intent17 = new Intent(MainActivity.this, TestActivity.class);
			startActivity(intent17);
			break;

		default:
			break;
			
		}
	}
	

}
