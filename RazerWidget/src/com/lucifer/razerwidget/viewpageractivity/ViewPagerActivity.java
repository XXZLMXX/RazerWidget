package com.lucifer.razerwidget.viewpageractivity;

import com.lucifer.razerwidget.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;



public class ViewPagerActivity extends Activity implements OnClickListener
{
	Button btn_colorful_imageview, btn_jazzy_imageview;
	

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.aty_viewpager);
		
		btn_colorful_imageview = (Button) findViewById(R.id.btn_colorful_imageview);
		btn_jazzy_imageview = (Button) findViewById(R.id.btn_jazzy_imageview);
		
		btn_colorful_imageview.setOnClickListener(this);
		btn_jazzy_imageview.setOnClickListener(this);
	}


	
	@Override
	public void onClick(View arg0)
	{
		// TODO Auto-generated method stub
		switch (arg0.getId())
		{
		case R.id.btn_colorful_imageview:
			Intent intent1 = new Intent(ViewPagerActivity.this, ColorfulViewPagerActivity.class);
			startActivity(intent1);
			break;
			
		case R.id.btn_jazzy_imageview:
			Intent intent2 = new Intent(ViewPagerActivity.this, JazzyViewPagerActivity.class);
			startActivity(intent2);
			break;

		default:
			break;
		}
	}

}
