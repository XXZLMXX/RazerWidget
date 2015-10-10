package com.lucifer.razerwidget.scrolllistgridviewactivity;


import com.lucifer.razerwidget.R;
import com.lucifer.razerwidget.scrolllistgridviewactivity.multifragmentsview.MultiFragmentsViewActivity;
import com.lucifer.razerwidget.scrolllistgridviewactivity.pullscrollview.PullScrollViewActivity;
import com.lucifer.razerwidget.scrolllistgridviewactivity.refreshloadmoreview.RefreshLoadmoreActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;



public class ScrollListGridViewActivity extends Activity implements OnClickListener
{
	Button btn_pullscroll_scrolllistgrid, btn_multifragments_scrolllistgrid, btn_refreshloadmore_scrolllistgrid;
	

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.aty_scrolllistgrid);
		
		btn_pullscroll_scrolllistgrid = (Button) findViewById(R.id.btn_pullscroll_scrolllistgrid);
		btn_multifragments_scrolllistgrid = (Button) findViewById(R.id.btn_multifragments_scrolllistgrid);
		btn_refreshloadmore_scrolllistgrid = (Button) findViewById(R.id.btn_refreshloadmore_scrolllistgrid);
		
		
		btn_pullscroll_scrolllistgrid.setOnClickListener(this);
		btn_multifragments_scrolllistgrid.setOnClickListener(this);
		btn_refreshloadmore_scrolllistgrid.setOnClickListener(this);
	}


	
	
	@Override
	public void onClick(View arg0)
	{
		// TODO Auto-generated method stub
		switch (arg0.getId())
		{
		case R.id.btn_pullscroll_scrolllistgrid:
			Intent intent7 = new Intent(ScrollListGridViewActivity.this, PullScrollViewActivity.class);
			startActivity(intent7);
			break;
			
		case R.id.btn_multifragments_scrolllistgrid:
			Intent intent8 = new Intent(ScrollListGridViewActivity.this, MultiFragmentsViewActivity.class);
			startActivity(intent8);
			break;
			
		case R.id.btn_refreshloadmore_scrolllistgrid:
			Intent intent9 = new Intent(ScrollListGridViewActivity.this, RefreshLoadmoreActivity.class);
			startActivity(intent9);
			break;

		default:
			break;
		}
	}
	
	
	
}
