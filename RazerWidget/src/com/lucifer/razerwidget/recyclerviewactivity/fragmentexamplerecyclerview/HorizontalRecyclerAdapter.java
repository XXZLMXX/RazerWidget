package com.lucifer.razerwidget.recyclerviewactivity.fragmentexamplerecyclerview;

import java.util.ArrayList;
import com.lucifer.razerwidget.R;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;



public class HorizontalRecyclerAdapter extends Adapter<HorizonalItemViewHolder>
{
	Context context;
	ArrayList<HorizonalItemBean> beans;
	
	
	
	public HorizontalRecyclerAdapter(Context c, ArrayList<HorizonalItemBean> l)
	{
		// TODO Auto-generated constructor stub
		this.context = c;
		this.beans = l;
	}
	
	

	@Override
	public int getItemCount()
	{
		// TODO Auto-generated method stub
		return beans.size();
	}
	
	
	
	@Override
	public HorizonalItemViewHolder onCreateViewHolder(ViewGroup arg0, int arg1)
	{
		// TODO Auto-generated method stub
		View view = LayoutInflater.from(context).inflate(
				R.layout.item_horizontal, null);
		
		return new HorizonalItemViewHolder(view);
	}
	
	
	

	@Override
	public void onBindViewHolder(HorizonalItemViewHolder arg0, int arg1)
	{
		// TODO Auto-generated method stub
		HorizonalItemBean currentBean = beans.get(arg1);
		arg0.tv_num_item.setText(currentBean.name);
		arg0.iv_num_item.setImageResource(currentBean.resourceId);
		
		final int item = arg1;
		arg0.iv_num_item.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				((FragmentExampleActivity)context).vp_fragmentexample.setCurrentItem(item);
			}
		});
		
		
	}
	
	


}
