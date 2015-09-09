package com.lucifer.razerwidget.scrolllistgridviewactivity;


import com.lucifer.razerwidget.R;
import com.lucifer.razerwidget.scrolllistgridviewactivity.pullscrolllistgridaty.PullScrollGridActivity;
import com.lucifer.razerwidget.scrolllistgridviewactivity.pullscrolllistgridaty.PullScrollListActivity;
import com.lucifer.razerwidget.scrolllistgridviewactivity.sortlistview.SortListViewActivity;
import com.lucifer.razerwidget.scrolllistgridviewactivity.topflowactivity.TopFlowActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;



public class ScrollListGridViewActivity extends Activity implements OnClickListener
{
	Button btn_list_scrolllistgrid, btn_grid_scrolllistgrid, btn_pulldown_scrolllistgrid; 
	Button btn_photowall_scrolllistgrid, btn_sortlistview_scrolllistgrid, btn_topflow_scrolllistgrid, btn_hybrid_scrolllistgrid;
	

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.aty_scrolllistgrid);
		
		btn_list_scrolllistgrid = (Button) findViewById(R.id.btn_list_scrolllistgrid);
		btn_grid_scrolllistgrid = (Button) findViewById(R.id.btn_grid_scrolllistgrid);
		btn_pulldown_scrolllistgrid = (Button) findViewById(R.id.btn_pulldown_scrolllistgrid);
		btn_photowall_scrolllistgrid = (Button) findViewById(R.id.btn_photowall_scrolllistgrid);
		btn_sortlistview_scrolllistgrid = (Button) findViewById(R.id.btn_sortlistview_scrolllistgrid);
		btn_topflow_scrolllistgrid = (Button) findViewById(R.id.btn_topflow_scrolllistgrid);
		btn_hybrid_scrolllistgrid = (Button) findViewById(R.id.btn_hybrid_scrolllistgrid);
	
		btn_list_scrolllistgrid.setOnClickListener(this);
		btn_grid_scrolllistgrid.setOnClickListener(this);
		btn_pulldown_scrolllistgrid.setOnClickListener(this);
		btn_photowall_scrolllistgrid.setOnClickListener(this);
		btn_sortlistview_scrolllistgrid.setOnClickListener(this);
		btn_topflow_scrolllistgrid.setOnClickListener(this);
		btn_hybrid_scrolllistgrid.setOnClickListener(this);
	}


	
	
	@Override
	public void onClick(View arg0)
	{
		// TODO Auto-generated method stub
		switch (arg0.getId())
		{
		case R.id.btn_list_scrolllistgrid:
			Intent intent1 = new Intent(ScrollListGridViewActivity.this, PullScrollListActivity.class);
			startActivity(intent1);
			break;
			
		case R.id.btn_grid_scrolllistgrid:
			Intent intent2 = new Intent(ScrollListGridViewActivity.this, PullScrollGridActivity.class);
			startActivity(intent2);	
			break;
					
		case R.id.btn_pulldown_scrolllistgrid:
			Intent intent3 = new Intent(ScrollListGridViewActivity.this, PullDownViewActivity.class);
			startActivity(intent3);
			break;
			
		case R.id.btn_photowall_scrolllistgrid:
			Intent intent4 = new Intent(ScrollListGridViewActivity.this, PhotoWallActivity.class);
			startActivity(intent4);
			break;
			
		case R.id.btn_sortlistview_scrolllistgrid:
			Intent intent5 = new Intent(ScrollListGridViewActivity.this, SortListViewActivity.class);
			startActivity(intent5);
			break;
			
		case R.id.btn_topflow_scrolllistgrid:
			Intent intent6 = new Intent(ScrollListGridViewActivity.this, TopFlowActivity.class);
			startActivity(intent6);
			break;
			
		case R.id.btn_hybrid_scrolllistgrid:
			
			break;

		default:
			break;
		}
	}
	
	
	
}
