package com.lucifer.razerwidget.scrolllistgridviewactivity.refreshloadmoreview;

import java.util.ArrayList;
import java.util.List;

import com.lucifer.razerlib.scrolllistgridview.PullScrollView.OnTurnListener;
import com.lucifer.razerwidget.R;
import com.lucifer.razerwidget.recyclerviewactivity.dragtoprecyclerview.fragments.FragmentExampleViewPagerAdapter;
import com.lucifer.razerwidget.scrolllistgridviewactivity.multifragmentsview.PhotoWallFragment;
import com.lucifer.razerwidget.scrolllistgridviewactivity.multifragmentsview.SortListViewFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.Toast;



public class RefreshLoadmoreActivity extends FragmentActivity
{
	ViewPager vp_multifragmentsview;
	FragmentExampleViewPagerAdapter fragmentExampleViewPagerAdapter;
	FragmentManager fragmentManager;
	List<Fragment> fragments;
	Fragment listScrollViewFragment = new ListScrollViewFragment();
	Fragment gridScrollViewFragment = new GridScrollViewFragment();
	Fragment autoFragment = new AutoLoadFragment();
	Fragment refreshLoadFragment = new RefreshLoadListViewFragment();
	Fragment zrcListViewFragment = new ZrcListViewFragment();
	

	@Override
	protected void onCreate(@Nullable Bundle arg0)
	{
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		
		setContentView(R.layout.aty_multifragmentsview);
		
		vp_multifragmentsview = (ViewPager) findViewById(R.id.vp_multifragmentsview);
		fragmentManager = getSupportFragmentManager();
		fragments = new ArrayList<>();
		fragments.add(listScrollViewFragment);
		fragments.add(gridScrollViewFragment);
		fragments.add(autoFragment);
		fragments.add(refreshLoadFragment);
		fragments.add(zrcListViewFragment);
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
