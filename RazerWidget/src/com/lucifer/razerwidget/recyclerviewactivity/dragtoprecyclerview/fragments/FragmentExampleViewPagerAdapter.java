package com.lucifer.razerwidget.recyclerviewactivity.dragtoprecyclerview.fragments;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;



public class FragmentExampleViewPagerAdapter extends FragmentPagerAdapter
{
	private List<Fragment> list;


	public FragmentExampleViewPagerAdapter(FragmentManager fm, List<Fragment> list)
	{
		super(fm);
		// TODO Auto-generated constructor stub
		this.list = list;
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
		return list.isEmpty() ? 0 : list.size();
	}

}