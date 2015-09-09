package com.lucifer.razerwidget.imageviewactivity;


import com.lucifer.razerlib.imageview.RotateView;
import com.lucifer.razerwidget.R;
import android.app.Activity;
import android.os.Bundle;



public class RotateViewActivity extends Activity
{
	RotateView rv_imageview;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.aty_rotateview);
		
		rv_imageview = (RotateView) findViewById(R.id.rv_imageview);
		rv_imageview.setRotateDrawableResource(R.drawable.cycle);
	}

}
