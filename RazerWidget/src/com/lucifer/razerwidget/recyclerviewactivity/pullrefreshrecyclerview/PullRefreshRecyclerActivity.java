package com.lucifer.razerwidget.recyclerviewactivity.pullrefreshrecyclerview;

import java.util.ArrayList;
import java.util.List;

import com.lucifer.razerwidget.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.TextView;



public class PullRefreshRecyclerActivity extends FragmentActivity
{
	TextView tv_sun_pullrefresh, tv_flight_pullrefresh;
	
	
	ViewPager vp_pullrefresh;
	PullRefreshPageAdapter pullRefreshPageAdapter;
	List<Fragment> list = new ArrayList<>();
	Fragment sunRecyclerFragment, flightRecyclerFragment;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.aty_pullrefreshrecycler);
		
		tv_sun_pullrefresh = (TextView) findViewById(R.id.tv_sun_pullrefresh);
		tv_flight_pullrefresh = (TextView) findViewById(R.id.tv_flight_pullrefresh);
		
		vp_pullrefresh = (ViewPager) findViewById(R.id.vp_pullrefresh);
		sunRecyclerFragment = new SunRecyclerFragment();
		flightRecyclerFragment = new FlightRecyclerFragment();
		list.add(sunRecyclerFragment);
		list.add(flightRecyclerFragment);
		pullRefreshPageAdapter = new PullRefreshPageAdapter(getSupportFragmentManager(), list);
		vp_pullrefresh.setAdapter(pullRefreshPageAdapter);
	}
	
	
	
}
