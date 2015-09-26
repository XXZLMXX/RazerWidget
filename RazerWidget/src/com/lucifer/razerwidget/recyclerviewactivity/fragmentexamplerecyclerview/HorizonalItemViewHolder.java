package com.lucifer.razerwidget.recyclerviewactivity.fragmentexamplerecyclerview;

import com.lucifer.razerwidget.R;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class HorizonalItemViewHolder extends ViewHolder
{
	TextView tv_num_item;
	ImageView iv_num_item;
	

	public HorizonalItemViewHolder(View arg0)
	{
		super(arg0);
		// TODO Auto-generated constructor stub
		tv_num_item = (TextView) arg0.findViewById(R.id.tv_num_item);
		iv_num_item = (ImageView) arg0.findViewById(R.id.iv_num_item);
	}

}
