package com.lucifer.razerwidget.recyclerviewactivity.fragmentexamplerecyclerview;

import java.util.ArrayList;
import java.util.List;

import com.lucifer.razerwidget.R;
import com.lucifer.razerwidget.recyclerviewactivity.dragtoprecyclerview.fragments.FragmentExampleViewPagerAdapter;
import com.lucifer.razerwidget.recyclerviewactivity.dragtoprecyclerview.fragments.GridViewRecyclerFragment;
import com.lucifer.razerwidget.recyclerviewactivity.dragtoprecyclerview.fragments.ListViewRecyclerFragment;
import com.lucifer.razerwidget.recyclerviewactivity.dragtoprecyclerview.fragments.StaggedRecyclerFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;



public class FragmentExampleActivity extends FragmentActivity implements OnClickListener
{
	RelativeLayout rl_firstfragment, rl_secondfragment, rl_thirdfragment;
	ViewPager vp_fragmentexample;
	FragmentExampleViewPagerAdapter fragmentExampleViewPagerAdapter;
	
	FragmentManager fragmentManager;
	FragmentTransaction transaction;
	List<Fragment> fragments = new ArrayList<>();
	Fragment listViewFragment = new ListViewRecyclerFragment();
    Fragment gridViewFragment = new GridViewRecyclerFragment();
    Fragment recyclerViewFragment = new StaggedRecyclerFragment();
	
    

	@Override
	protected void onCreate(@Nullable Bundle arg0)
	{
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		
		setContentView(R.layout.aty_fragmentexample);
		
		
		rl_firstfragment = (RelativeLayout) findViewById(R.id.rl_firstfragment);
		rl_secondfragment = (RelativeLayout) findViewById(R.id.rl_secondfragment);
		rl_thirdfragment = (RelativeLayout) findViewById(R.id.rl_thirdfragment);
		
		
		vp_fragmentexample = (ViewPager) findViewById(R.id.vp_fragmentexample);
		
		
		
		rl_firstfragment.setOnClickListener(this);
		rl_secondfragment.setOnClickListener(this);
		rl_thirdfragment.setOnClickListener(this);
		
		fragmentManager = getSupportFragmentManager();
		fragments.add(listViewFragment);
        fragments.add(gridViewFragment);
        fragments.add(recyclerViewFragment);
        fragmentExampleViewPagerAdapter = new FragmentExampleViewPagerAdapter(fragmentManager, fragments);
        vp_fragmentexample.setAdapter(fragmentExampleViewPagerAdapter);
        
        vp_fragmentexample.setOnPageChangeListener(new OnPageChangeListener()
		{
			@Override
			public void onPageSelected(int arg0)
			{
				// TODO Auto-generated method stub
				vp_fragmentexample.setCurrentItem(arg0);
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

	
	
	@Override
	public void onClick(View v)
	{
		// TODO Auto-generated method stub
		switch (v.getId())
		{
		case R.id.rl_firstfragment:
			switchFragment(0);
			break;
			
		case R.id.rl_secondfragment:
			switchFragment(1);
			break;
					
		case R.id.rl_thirdfragment:
			switchFragment(2);
			break;

		default:
			break;
		}
		
	}
	
	
	private void switchFragment(int index)
	{
		transaction = fragmentManager.beginTransaction();
		transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
		for (int i = 0; i < fragments.size(); i++)
		{
			if (index == i)
			{
				transaction.show(fragments.get(index));
			} else
			{
				transaction.hide(fragments.get(i));
			}
		}
		transaction.commit();
	}
	
	
}
