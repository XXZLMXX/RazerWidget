package com.lucifer.razerwidget.recyclerviewactivity;

import com.lucifer.razerwidget.R;
import com.lucifer.razerwidget.recyclerviewactivity.dragtoprecyclerview.DragRecyclerViewActivity;
import com.lucifer.razerwidget.recyclerviewactivity.fragmentexamplerecyclerview.FragmentExampleActivity;
import com.lucifer.razerwidget.recyclerviewactivity.pullrefreshrecyclerview.PullRefreshRecyclerActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;



public class RecyclerViewActivity extends Activity implements OnClickListener
{
	Button btn_dragtop_recyclerview, btn_viewpager_recyclerview, 
	btn_swipeload_recyclerview, btn_fragmentexample_recyclerview;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.aty_recyclerview);
		
		btn_dragtop_recyclerview = (Button) findViewById(R.id.btn_dragtop_recyclerview);
		btn_viewpager_recyclerview = (Button) findViewById(R.id.btn_viewpager_recyclerview);
		btn_swipeload_recyclerview = (Button) findViewById(R.id.btn_swipeload_recyclerview);
		btn_fragmentexample_recyclerview = (Button) findViewById(R.id.btn_fragmentexample_recyclerview);
		
		btn_dragtop_recyclerview.setOnClickListener(this);
		btn_viewpager_recyclerview.setOnClickListener(this);
		btn_swipeload_recyclerview.setOnClickListener(this);
		btn_fragmentexample_recyclerview.setOnClickListener(this);
	}



	@Override
	public void onClick(View arg0)
	{
		// TODO Auto-generated method stub
		switch (arg0.getId())
		{
		case R.id.btn_dragtop_recyclerview:
			Intent intent = new Intent(RecyclerViewActivity.this, DragRecyclerViewActivity.class);
			startActivity(intent);
			break;
			
		case R.id.btn_viewpager_recyclerview:
			
			break;
			
		case R.id.btn_swipeload_recyclerview:
			Intent intent3 = new Intent(RecyclerViewActivity.this, PullRefreshRecyclerActivity.class);
			startActivity(intent3);
			break;
			
		case R.id.btn_fragmentexample_recyclerview:
			Intent intent4 = new Intent(RecyclerViewActivity.this, FragmentExampleActivity.class);
			startActivity(intent4);
			break;

		default:
			break;
		}
	}
	
}
