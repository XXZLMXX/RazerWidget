package com.lucifer.razerwidget.recyclerviewactivity.fragmentexamplerecyclerview;

import java.util.ArrayList;
import java.util.List;
import com.lucifer.razerwidget.R;
import com.lucifer.razerwidget.recyclerviewactivity.dragtoprecyclerview.fragments.FlightRecyclerFragment;
import com.lucifer.razerwidget.recyclerviewactivity.dragtoprecyclerview.fragments.FragmentExampleViewPagerAdapter;
import com.lucifer.razerwidget.recyclerviewactivity.dragtoprecyclerview.fragments.GridViewRecyclerFragment;
import com.lucifer.razerwidget.recyclerviewactivity.dragtoprecyclerview.fragments.ListViewRecyclerFragment;
import com.lucifer.razerwidget.recyclerviewactivity.dragtoprecyclerview.fragments.StaggedRecyclerFragment;
import com.lucifer.razerwidget.recyclerviewactivity.dragtoprecyclerview.fragments.SunRecyclerFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;



public class FragmentExampleActivity extends FragmentActivity implements OnClickListener
{
//	RelativeLayout rl_firstfragment, rl_secondfragment, rl_thirdfragment;
	public RecyclerView rclv_fragmentexample;
	StaggeredGridLayoutManager staggeredGridLayoutManager;
	ArrayList<HorizonalItemBean> horizonalItemBeans;
	HorizontalRecyclerAdapter horizontalRecyclerAdapter;
	
	public ViewPager vp_fragmentexample;
	FragmentExampleViewPagerAdapter fragmentExampleViewPagerAdapter;
	
	FragmentManager fragmentManager;
	FragmentTransaction transaction;
	List<Fragment> fragments = new ArrayList<>();
	Fragment listViewFragment = new ListViewRecyclerFragment();
    Fragment gridViewFragment = new GridViewRecyclerFragment();
    Fragment recyclerViewFragment = new StaggedRecyclerFragment();
    Fragment sunFragment = new SunRecyclerFragment();
    Fragment flightFragment = new FlightRecyclerFragment();
    

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle arg0)
	{
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.aty_fragmentexample);
		
		
		/*rl_firstfragment = (RelativeLayout) findViewById(R.id.rl_firstfragment);
		rl_secondfragment = (RelativeLayout) findViewById(R.id.rl_secondfragment);
		rl_thirdfragment = (RelativeLayout) findViewById(R.id.rl_thirdfragment);*/
		rclv_fragmentexample = (RecyclerView) findViewById(R.id.rclv_fragmentexample);
		
		
		vp_fragmentexample = (ViewPager) findViewById(R.id.vp_fragmentexample);
		
		
		/*rl_firstfragment.setOnClickListener(this);
		rl_secondfragment.setOnClickListener(this);
		rl_thirdfragment.setOnClickListener(this);*/
		staggeredGridLayoutManager = new StaggeredGridLayoutManager(1,
				StaggeredGridLayoutManager.HORIZONTAL);
		rclv_fragmentexample.setLayoutManager(staggeredGridLayoutManager);
		horizonalItemBeans = new ArrayList<>();
		HorizonalItemBean horizonalItemBean1 = new HorizonalItemBean();
		horizonalItemBean1.name = "第一个";
		horizonalItemBean1.resourceId = R.drawable.a2;
		horizonalItemBeans.add(horizonalItemBean1);
		
		HorizonalItemBean horizonalItemBean2 = new HorizonalItemBean();
		horizonalItemBean2.name = "第二个";
		horizonalItemBean2.resourceId = R.drawable.a3;
		horizonalItemBeans.add(horizonalItemBean2);
		
		HorizonalItemBean horizonalItemBean3 = new HorizonalItemBean();
		horizonalItemBean3.name = "第三个";
		horizonalItemBean3.resourceId = R.drawable.a4;
		horizonalItemBeans.add(horizonalItemBean3);
		
		HorizonalItemBean horizonalItemBean4 = new HorizonalItemBean();
		horizonalItemBean4.name = "第四个";
		horizonalItemBean4.resourceId = R.drawable.sun;
		horizonalItemBeans.add(horizonalItemBean4);
		
		HorizonalItemBean horizonalItemBean5 = new HorizonalItemBean();
		horizonalItemBean5.name = "第五个";
		horizonalItemBean5.resourceId = R.drawable.airplane;
		horizonalItemBeans.add(horizonalItemBean5);
		
		horizontalRecyclerAdapter = new HorizontalRecyclerAdapter(this, horizonalItemBeans);
		rclv_fragmentexample.setAdapter(horizontalRecyclerAdapter);
		
		rclv_fragmentexample.setOnScrollListener(new OnScrollListener()
		{

			@Override
			public void onScrollStateChanged(RecyclerView recyclerView,
					int newState)
			{
				// TODO Auto-generated method stub
				super.onScrollStateChanged(recyclerView, newState);
				
			}

			
			@Override
			public void onScrolled(RecyclerView recyclerView, int dx, int dy)
			{
				// TODO Auto-generated method stub
				super.onScrolled(recyclerView, dx, dy);
				
				int[] firstPositions = new int[10];
				firstPositions = staggeredGridLayoutManager.findFirstVisibleItemPositions(firstPositions);
				int current = firstPositions[0];
				vp_fragmentexample.setCurrentItem(current);
			}
			
		});
		
		
		
		fragmentManager = getSupportFragmentManager();
		fragments.add(listViewFragment);
        fragments.add(gridViewFragment);
        fragments.add(recyclerViewFragment);
        fragments.add(sunFragment);
        fragments.add(flightFragment);
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
		/*case R.id.rl_firstfragment:
			switchFragment(0);
			break;
			
		case R.id.rl_secondfragment:
			switchFragment(1);
			break;
					
		case R.id.rl_thirdfragment:
			switchFragment(2);
			break;*/

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
