package com.lucifer.razerwidget.scrolllistgridviewactivity.multifragmentsview;

import java.util.ArrayList;
import java.util.List;

import com.lucifer.razerlib.scrolllistgridview.viewpagerlistview.View1;
import com.lucifer.razerwidget.R;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class ViewPagerListViewFragment extends Fragment
{
	View view;
	ViewPager vp_vplistview;
	private List<View> list = new ArrayList<View>();
	private MyPageAdapter adapter;
	

	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.fragment_viewpagerlistview, null);
		vp_vplistview = (ViewPager) view.findViewById(R.id.vp_vplistview);

		initData();
		adapter = new MyPageAdapter();
		vp_vplistview.setAdapter(adapter);
		
		
		return view;
	}
	
	
	
	private void initData()
	{
		
		list.add(new View1(getActivity()).listview);
		list.add(new View1(getActivity()).listview);
		list.add(new View1(getActivity()).listview);
	}

	
	
	class MyPageAdapter extends PagerAdapter
	{

		@Override
		public int getCount()
		{
			return list.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1)
		{
			return arg0 == arg1;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position)
		{
			((ViewGroup) container).addView((View) list.get(position));
			return list.get(position);

		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object)
		{
			container.removeView(list.get(position));
		}

	}

	
	
	
}	
