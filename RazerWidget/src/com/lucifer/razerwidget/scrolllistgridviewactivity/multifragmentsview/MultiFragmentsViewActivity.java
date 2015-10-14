package com.lucifer.razerwidget.scrolllistgridviewactivity.multifragmentsview;

import java.util.ArrayList;
import java.util.List;

import com.lucifer.razerwidget.R;
import com.lucifer.razerwidget.recyclerviewactivity.dragtoprecyclerview.fragments.FragmentExampleViewPagerAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;



public class MultiFragmentsViewActivity extends FragmentActivity
{
	ViewPager vp_multifragmentsview;
	FragmentExampleViewPagerAdapter fragmentExampleViewPagerAdapter;
	FragmentManager fragmentManager;
	List<Fragment> fragments;
	Fragment photoWallFragment = new PhotoWallFragment();
	Fragment sortListViewFragment = new SortListViewFragment();
	Fragment viewpagerListViewFragment = new ViewPagerListViewFragment();
	
	
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.aty_multifragmentsview);
		
		vp_multifragmentsview = (ViewPager) findViewById(R.id.vp_multifragmentsview);
		fragmentManager = getSupportFragmentManager();
		fragments = new ArrayList<>();
		fragments.add(photoWallFragment);
		fragments.add(sortListViewFragment);
		fragments.add(viewpagerListViewFragment);
		fragmentExampleViewPagerAdapter = new FragmentExampleViewPagerAdapter(fragmentManager, fragments);
		vp_multifragmentsview.setAdapter(fragmentExampleViewPagerAdapter);
		
		vp_multifragmentsview.setOnPageChangeListener(new OnPageChangeListener()
		{
			
			@Override
			public void onPageSelected(int arg0)
			{
				// TODO Auto-generated method stub
				vp_multifragmentsview.setCurrentItem(arg0);
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0)
			{
				// TODO Auto-generated method stub
				
			}
		});
		
		
	}
	
}
