package com.lucifer.razerwidget.imageviewactivity;

import com.lucifer.razerwidget.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ImageViewActivity extends Activity implements OnClickListener
{
	Button btn_round_imageview, btn_mytouch_imageview, btn_photosort_imageview, 
	btn_rectanglescreenshot_imageview, btn_systemscreenshot_imageview, 
	btn_circlescreenshot_imageview, btn_rotate_imageview, btn_tag_imageview, btn_radiogroup_imageview;
	

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.aty_imageview);
		
		btn_round_imageview = (Button) findViewById(R.id.btn_round_imageview);
		btn_mytouch_imageview = (Button) findViewById(R.id.btn_mytouch_imageview);
		btn_photosort_imageview = (Button) findViewById(R.id.btn_photosort_imageview);
		btn_rectanglescreenshot_imageview = (Button) findViewById(R.id.btn_rectanglescreenshot_imageview);
		btn_systemscreenshot_imageview = (Button) findViewById(R.id.btn_systemscreenshot_imageview);
		btn_circlescreenshot_imageview = (Button) findViewById(R.id.btn_circlescreenshot_imageview);
		btn_rotate_imageview = (Button) findViewById(R.id.btn_rotate_imageview);
		btn_tag_imageview = (Button) findViewById(R.id.btn_tag_imageview);
		btn_radiogroup_imageview = (Button) findViewById(R.id.btn_radiogroup_imageview);
		
		
		btn_round_imageview.setOnClickListener(this);
		btn_mytouch_imageview.setOnClickListener(this);
		btn_photosort_imageview.setOnClickListener(this);
		btn_rectanglescreenshot_imageview.setOnClickListener(this);
		btn_systemscreenshot_imageview.setOnClickListener(this);
		btn_circlescreenshot_imageview.setOnClickListener(this);
		btn_rotate_imageview.setOnClickListener(this);
		btn_tag_imageview.setOnClickListener(this);
		btn_radiogroup_imageview.setOnClickListener(this);
	}

	
	
	@Override
	public void onClick(View arg0)
	{
		// TODO Auto-generated method stub
		switch (arg0.getId())
		{
		case R.id.btn_round_imageview:
			Intent intent1 = new Intent(ImageViewActivity.this, RoundImageActivity.class);
			startActivity(intent1);
			break;
			
		case R.id.btn_mytouch_imageview:
			Intent intent2 = new Intent(ImageViewActivity.this, MyTouchImageViewActivity.class);
			startActivity(intent2);	
			break;
			
		case R.id.btn_photosort_imageview:
			Intent intent7 = new Intent(ImageViewActivity.this, PhotoSortActivity.class);
			startActivity(intent7);
			break;
			
		case R.id.btn_rectanglescreenshot_imageview:
			Intent intent3 = new Intent(ImageViewActivity.this, CropImageActivity.class);
			startActivity(intent3);
			break;
			
		case R.id.btn_circlescreenshot_imageview:
			Intent intent6 = new Intent(ImageViewActivity.this, CircleScreenShotActivity.class);
			startActivity(intent6);
			break;
			
		case R.id.btn_systemscreenshot_imageview:
			Intent intent4 = new Intent(ImageViewActivity.this, SystemScreenShotActivity.class);
			startActivity(intent4);
			break;
			
		case R.id.btn_rotate_imageview:
			Intent intent5 = new Intent(ImageViewActivity.this, RotateViewActivity.class);
			startActivity(intent5);
			break;
			
		case R.id.btn_tag_imageview:
			Intent intent8 = new Intent(ImageViewActivity.this, TagImageViewActivity.class);
			startActivity(intent8);
			break;
			
		case R.id.btn_radiogroup_imageview:
			Intent intent9 = new Intent(ImageViewActivity.this, RadioGroupActivity.class);
			startActivity(intent9);
			break;

		default:
			break;
		}
	}

}
