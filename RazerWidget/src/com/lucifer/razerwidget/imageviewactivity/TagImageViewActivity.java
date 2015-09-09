package com.lucifer.razerwidget.imageviewactivity;

import com.lucifer.razerlib.imageview.TagImageView;
import com.lucifer.razerwidget.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TagImageViewActivity extends Activity
{
	TagImageView tiv_tag_imageview;
	Button btn_tag_imageview;
	

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.aty_tag_imageview);
		
		tiv_tag_imageview = (TagImageView) findViewById(R.id.tiv_tag_imageview);
		btn_tag_imageview = (Button) findViewById(R.id.btn_tag_imageview);
		
		
		btn_tag_imageview.setOnClickListener(new OnClickListener()
		{
			int i = 0;
			
			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				tiv_tag_imageview.addTextTag("nimei" + i++, 40, 40);
			}
		});
	}
	
}
