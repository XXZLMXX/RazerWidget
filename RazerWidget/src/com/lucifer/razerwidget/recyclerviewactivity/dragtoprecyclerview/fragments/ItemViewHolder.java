package com.lucifer.razerwidget.recyclerviewactivity.dragtoprecyclerview.fragments;

import com.lucifer.razerwidget.R;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemViewHolder extends ViewHolder
{

	ImageView iv_item_image;

	public ItemViewHolder(View view)
	{
		super(view);
		iv_item_image = (ImageView) view.findViewById(R.id.iv_item_image);
	}
		
}
