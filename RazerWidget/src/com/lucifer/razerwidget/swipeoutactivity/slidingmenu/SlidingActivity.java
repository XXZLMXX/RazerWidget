package com.lucifer.razerwidget.swipeoutactivity.slidingmenu;

import com.lucifer.razerlib.slidingmenu.SlidingMenu;
import com.lucifer.razerwidget.R;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;


public class SlidingActivity extends FragmentActivity
{
	SlidingMenu mSlidingMenu;
	
	LeftFragment leftFragment;
	RightFragment rightFragment;
	SampleListFragment centerFragment;

	
	
	@Override
	protected void onCreate(Bundle arg0)
	{
		super.onCreate(arg0);
		setContentView(R.layout.aty_slidingmenu);
		
		mSlidingMenu = (SlidingMenu) findViewById(R.id.sm_slidingmenu);
		
		mSlidingMenu.setLeftView(getLayoutInflater().inflate(
				R.layout.left_frame, null));
		mSlidingMenu.setRightView(getLayoutInflater().inflate(
				R.layout.right_frame, null));
		mSlidingMenu.setCenterView(getLayoutInflater().inflate(
				R.layout.center_frame, null));
		

		FragmentTransaction t = this.getSupportFragmentManager()
				.beginTransaction();
		leftFragment = new LeftFragment();
		t.replace(R.id.left_frame, leftFragment);

		rightFragment = new RightFragment();
		t.replace(R.id.right_frame, rightFragment);

		centerFragment = new SampleListFragment();
		t.replace(R.id.center_frame, centerFragment);
		t.commit();

	}

	
	
	public void showLeft()
	{
		mSlidingMenu.showLeftView();
	}

	
	
	public void showRight()
	{
		mSlidingMenu.showRightView();
	}

}
