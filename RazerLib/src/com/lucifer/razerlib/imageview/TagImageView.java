package com.lucifer.razerlib.imageview;

import java.util.ArrayList;
import java.util.List;

import com.lucifer.razerlib.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;



public class TagImageView extends RelativeLayout
{
	private Context context;

	List<View> tagViewList;

	public TagImageView(Context context, AttributeSet attrs, int defStyle)
	{
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		this.context = context;
	}

	public TagImageView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		// TODO Auto-generated constructor stub
		this.context = context;
	}

	public TagImageView(Context context)
	{
		super(context);
		// TODO Auto-generated constructor stub
		this.context = context;
	}

	
	
	public void addTextTag(String content, int x, int y)
	{
		if (tagViewList == null)
			tagViewList = new ArrayList<View>();
		LayoutInflater mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View view = mInflater.inflate(R.layout.imageview_tag, null);
		TextView text = (TextView) view.findViewById(R.id.tag_text);
		RelativeLayout layout = (RelativeLayout) view
				.findViewById(R.id.tag_layout);
		text.setText(content);
		
		layout.setOnTouchListener(new OnTouchListener()
		{
			int startx = 0;
			int starty = 0;

			@Override
			public boolean onTouch(View v, MotionEvent event)
			{
				// TODO Auto-generated method stub
				if (v.getId() == R.id.tag_layout)
				{
					switch (event.getAction())
					{
					case MotionEvent.ACTION_DOWN:
						startx = (int) event.getRawX();
						starty = (int) event.getRawY();
						break;
						
					case MotionEvent.ACTION_MOVE:
						int x = (int) event.getRawX();
						int y = (int) event.getRawY();
						int dx = x - startx;
						int dy = y - starty;

						setPosition(v, dx, dy);

						startx = (int) event.getRawX();
						starty = (int) event.getRawY();
						break;
					}
				}
				return true;
			}
		});
		
		
		this.addView(layout);
		setPosition(layout, x, y);
		tagViewList.add(layout);
	}

	
	
	private void setPosition(View v, int dx, int dy)
	{
		int parentWidth = this.getWidth();
		int parentHeight = this.getHeight();
		int l = v.getLeft() + dx;
		int t = v.getTop() + dy;
		
		if (l < 0)
		{l = 0;}
		else if ((l + v.getWidth()) >= parentWidth)
		{
			l = parentWidth - v.getWidth();
		}
		
		if (t < 0)
		{t = 0;}
		else if ((t + v.getHeight()) >= parentHeight)
		{
			t = parentHeight - v.getHeight();
		}
		
		int r = l + v.getWidth();
		int b = t + v.getHeight();
		
		v.layout(l, t, r, b);
		
		RelativeLayout.LayoutParams params = (android.widget.RelativeLayout.LayoutParams) v
				.getLayoutParams();
		params.leftMargin = l;
		params.topMargin = t;
		v.setLayoutParams(params);
	}

}
