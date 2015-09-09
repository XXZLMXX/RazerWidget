package com.lucifer.razerwidget.imageviewactivity;


import com.lucifer.razerlib.imageview.MyTouchImageView;
import com.lucifer.razerlib.utils.ImageUtils;
import com.lucifer.razerwidget.R;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.LinearLayout;



public class MyTouchImageViewActivity extends Activity
{
	Bitmap bitmap;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		bitmap = ImageUtils.resouceIdToBitmap(MyTouchImageViewActivity.this, R.drawable.image);
		MyTouchImageView myTouchImageView = new MyTouchImageView(this);
		myTouchImageView.setBitmap(bitmap);
		
		setContentView(myTouchImageView);
		
	}
	

}
