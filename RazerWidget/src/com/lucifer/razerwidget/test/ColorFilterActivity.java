package com.lucifer.razerwidget.test;

import com.lucifer.razerlib.test.ColorFilterView;
import com.lucifer.razerwidget.R;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class ColorFilterActivity extends Activity implements OnClickListener
{
	Button btn_color_colorfilter, btn_light_colorfilter, btn_porter_colorfilter;
	
	ColorFilterView cfv_colorfilter;
	

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.aty_colorfilter);
		
		btn_color_colorfilter = (Button) findViewById(R.id.btn_color_colorfilter);
		btn_light_colorfilter = (Button) findViewById(R.id.btn_light_colorfilter);
		btn_porter_colorfilter = (Button) findViewById(R.id.btn_porter_colorfilter);
		
		cfv_colorfilter = (ColorFilterView) findViewById(R.id.cfv_colorfilter);

		btn_color_colorfilter.setOnClickListener(this);
		btn_light_colorfilter.setOnClickListener(this);
		btn_porter_colorfilter.setOnClickListener(this);
	}


	@Override
	public void onClick(View v)
	{
		// TODO Auto-generated method stub
		switch (v.getId())
		{
		case R.id.btn_color_colorfilter:
			ColorMatrix colorMatrix = new ColorMatrix(new float[]
			{  
		        0.5F, 0, 0, 0, 0,  
		        0, 0.5F, 0, 0, 0,  
		        0, 0, 0.5F, 0, 0,  
		        0, 0, 0, 1, 0,  
			});   
			cfv_colorfilter.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
			break;
			
		case R.id.btn_light_colorfilter:
			cfv_colorfilter.setColorFilter(new LightingColorFilter(0xFFFF00FF, 0x00000000));
			break;
					
		case R.id.btn_porter_colorfilter:
			cfv_colorfilter.setColorFilter(new PorterDuffColorFilter(Color.RED,  Mode.DARKEN));
			break;

		default:
			break;
		}
	}
	
}
