package com.lucifer.razerwidget.FlipPageActivity;

import com.lucifer.razerwidget.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;



public class FlipPageActivity extends Activity implements OnClickListener
{
	Button btn_curlview, btn_flipview;
	

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.aty_flippage);
		
		
		btn_curlview = (Button) findViewById(R.id.btn_curlview);
		btn_flipview = (Button) findViewById(R.id.btn_flipview);
		
		
		btn_curlview.setOnClickListener(this);
		btn_flipview.setOnClickListener(this);
	}

	
	

	@Override
	public void onClick(View v)
	{
		// TODO Auto-generated method stub
		switch (v.getId())
		{
		case R.id.btn_curlview:
			Intent intent1 = new Intent(FlipPageActivity.this, CurlViewActivity.class);
			startActivity(intent1);
			break;
			
			
		case R.id.btn_flipview:
			
			break;
			

		default:
			break;
		}
	}
	
}
