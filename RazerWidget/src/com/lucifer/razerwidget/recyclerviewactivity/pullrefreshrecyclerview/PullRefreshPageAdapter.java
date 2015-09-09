package com.lucifer.razerwidget.recyclerviewactivity.pullrefreshrecyclerview;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PullRefreshPageAdapter extends FragmentPagerAdapter
{
	List<Fragment> list;

	public PullRefreshPageAdapter(FragmentManager fm)
	{
		super(fm);
		// TODO Auto-generated constructor stub
	}
	
	
	public PullRefreshPageAdapter(FragmentManager fm, List<Fragment> l)
	{
		super(fm);
		// TODO Auto-generated constructor stub
		this.list = l;
	}
	

	@Override
	public Fragment getItem(int arg0)
	{
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public int getCount()
	{
		// TODO Auto-generated method stub
		return list.size();
	}

}
